package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_wybor_programu.*

class WyborProgramu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wybor_programu)
        val wjazd = AnimationUtils.loadAnimation(this, R.anim.wjazd)
        val wjazdZLewej = AnimationUtils.loadAnimation(this, R.anim.wjazd_z_lewej)
        lodowka.startAnimation(wjazd)
        chrapka.startAnimation(wjazdZLewej)
    }
}