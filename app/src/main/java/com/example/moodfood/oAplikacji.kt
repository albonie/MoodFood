package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class oAplikacji : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o_aplikacji)
        val actionbar = supportActionBar
        actionbar!!.title = "O Aplikacji"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}