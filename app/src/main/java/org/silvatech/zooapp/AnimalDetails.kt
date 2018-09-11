package org.silvatech.zooapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.animal_ticket.*

class AnimalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val bundle:Bundle = intent.extras
        val name = bundle.getString("name")
        val desc = bundle.getString("desc")
        val image = bundle.getInt("image")
        ivAnimalmage.setImageResource(image)
        tvName.text=name
        tvDesc.text=desc
    }
}
