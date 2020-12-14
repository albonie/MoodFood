package com.example.moodfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val wjazd = AnimationUtils.loadAnimation(this, R.anim.wjazd)
        val wjazd2 = AnimationUtils.loadAnimation(this, R.anim.wjazd2)
        val wjazdZLewej = AnimationUtils.loadAnimation(this, R.anim.wjazd_z_lewej)
        val wjazdZLewej2 = AnimationUtils.loadAnimation(this, R.anim.wjazd_z_lewej2)
        buttonOpcje.startAnimation(wjazd)
        buttonProgram.startAnimation(wjazd2)
        buttonPrzepis.startAnimation(wjazdZLewej)
        buttonInfo.startAnimation(wjazdZLewej2)
        buttonPrzepis.setOnClickListener{
            val intent = Intent(this, Przepisy::class.java)
            startActivity(intent)
        }
        buttonProgram.setOnClickListener {
            val intent = Intent(this, WyborProgramu::class.java)
            startActivity(intent)
        }
        buttonOpcje.setOnClickListener {
            val intent = Intent(this, Opcyje::class.java)
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.settings_action) {
            Toast.makeText(this, "opcje", Toast.LENGTH_SHORT).show()
            return true
        }
        if (id == R.id.info_action) {
            Toast.makeText(this, "o aplikacji", Toast.LENGTH_SHORT).show()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


