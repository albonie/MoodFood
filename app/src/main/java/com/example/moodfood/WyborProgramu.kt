package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_wybor_programu.*

class WyborProgramu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wybor_programu)
        lodowka.text = "Lodówka"
        chrapka.text = "Chrapka"
    }
}