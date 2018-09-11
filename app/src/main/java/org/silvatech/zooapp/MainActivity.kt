package org.silvatech.zooapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*

class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter:AnimalsAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load animal
        listOfAnimals.add(Animal("Baboon","Baboon lives in big place with trees",R.drawable.baboon,false))
        listOfAnimals.add(Animal("bulldog","bulldog lives in big place with trees",R.drawable.bulldog,false))
        listOfAnimals.add(Animal("panda","panda lives in big place with trees",R.drawable.panda,false))
        listOfAnimals.add(Animal("swallow_bird","swallow_bird lives in big place with trees",R.drawable.swallow_bird,false))
        listOfAnimals.add(Animal("white_tiger","white_tiger lives in big place with trees",R.drawable.white_tiger,true))
        listOfAnimals.add(Animal("zebra","zebra lives in big place with trees",R.drawable.zebra,false))

        adapter = AnimalsAdapter(this,listOfAnimals)
        tvListAnimal.adapter= adapter

    }
    class AnimalsAdapter:BaseAdapter{
        var listOfAnimals=ArrayList<Animal>()
        var context:Context?=null
        constructor(context:Context, listOfAnimals: ArrayList<Animal>):super(){
            this.listOfAnimals=listOfAnimals
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val animal = listOfAnimals[position]
            if (animal.isKiller == true) {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_killer_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDesc.text = animal.desc!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                return myView
            }else {
                var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
                var myView = inflator.inflate(R.layout.animal_ticket, null)
                myView.tvName.text = animal.name!!
                myView.tvDesc.text = animal.desc!!
                myView.ivAnimalImage.setImageResource(animal.image!!)
                return myView
            }
        }

        override fun getItem(position: Int): Any {

            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfAnimals.size
        }

    }
}
