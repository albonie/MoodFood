package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moodfood.chrapka.SkladnikArray
import kotlinx.android.synthetic.main.activity_chrapka_wyniki.*


class ChrapkaWyniki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrapka_wyniki)


        val wybraneSkladniki = ArrayList<String>()

        val wyniki = intent.getParcelableArrayListExtra<SkladnikArray>("Skladniki")

        if (wyniki != null) {
            for (i in 0 until wyniki.size) {
                if (wyniki[i].checked) {
                    wyniki[i].getNazwa()?.let { wybraneSkladniki.add(it) }
                }
            }
        }

        var str = ""
        wybraneSkladniki.forEach { skladnik ->
            str += "$skladnik "
        }
        test.text = str

    }
}