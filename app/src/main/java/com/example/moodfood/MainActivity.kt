package com.example.moodfood

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val wjazd2 = AnimationUtils.loadAnimation(this, R.anim.wjazd2)
        val wjazdZLewej = AnimationUtils.loadAnimation(this, R.anim.wjazd_z_lewej)
        val click = AnimationUtils.loadAnimation(this, R.anim.click)
        chrapka.startAnimation(wjazd2)
        lodowka.startAnimation(wjazdZLewej)
        buttonPrzepis.startAnimation(wjazd2)

        buttonPrzepis.setOnClickListener{
            buttonPrzepis.startAnimation(click)

            val intent = Intent(this, Przepisy::class.java)
            startActivity(intent)
        }
        chrapka.setOnClickListener {
            chrapka.startAnimation(click)
            val intent = Intent(this, Chrapka::class.java)
            startActivity(intent)
        }

        lodowka.setOnClickListener {
            lodowka.startAnimation(click)
            val intent = Intent(this, Lodowka::class.java)
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
                val intent = Intent(this, Opcyje::class.java)
                startActivity(intent)
            return true
        }
        if (id == R.id.info_action) {
            val intent = Intent(this, oAplikacji::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


