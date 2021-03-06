package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_przepisy.*

class Przepisy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_przepisy)
        BADD.setOnClickListener {
            val message = Toast.makeText(applicationContext,"Dodano!",Toast.LENGTH_SHORT)
            message.show()
        }
        BDELETE.setOnClickListener {
            val message2 = Toast.makeText(applicationContext,"Usunięto!",Toast.LENGTH_SHORT)
            message2.show()
        }
        val actionbar = supportActionBar
        actionbar!!.title = "Przepisy"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}