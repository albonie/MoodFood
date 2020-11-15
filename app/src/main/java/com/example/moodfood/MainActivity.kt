package com.example.moodfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPrzepis.setOnClickListener{
            val intent = Intent(this, Przepisy::class.java)
            startActivity(intent)
        }
        buttonProgram.setOnClickListener {
            val intent = Intent(this, WyborProgramu::class.java)
            startActivity(intent)
        }
    }
}