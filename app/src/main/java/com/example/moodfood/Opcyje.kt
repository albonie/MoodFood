package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Opcyje : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opcyje)
        val actionbar = supportActionBar
        actionbar!!.title = "Ustawienia"
        actionbar.setDisplayHomeAsUpEnabled(true)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}