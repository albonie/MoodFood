package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moodfood.chrapka.SkladnikArray
import com.example.moodfood.przepisy.PrzepisAdapter
import com.example.moodfood.przepisy.PrzepisElement
import kotlinx.android.synthetic.main.activity_chrapka_wyniki.*


class ChrapkaWyniki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrapka_wyniki)

        supportActionBar?.hide()

        val wybraneSkladniki = ArrayList<String>()

        val wyniki = intent.getParcelableArrayListExtra<SkladnikArray>("Skladniki")



        val lista = createList(5)

        przepis_recycler_view.adapter = PrzepisAdapter(lista)
        przepis_recycler_view.layoutManager = LinearLayoutManager(this)
        przepis_recycler_view.setHasFixedSize(true)

    }
    private fun createList(size: Int): List<PrzepisElement> {
        val list = ArrayList<PrzepisElement>()
        for (i in 0 until size) {
            val item = PrzepisElement(R.drawable.cuttlery, R.drawable.jajecznica, "Tytul ${i+1}", "Opis")
            list+=item
        }
        return list

    }
}