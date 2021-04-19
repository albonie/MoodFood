package com.example.moodfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moodfood.chrapka.SkladnikArray
import com.example.moodfood.przepisy.PrzepisAdapter
import com.example.moodfood.przepisy.PrzepisElement
import kotlinx.android.synthetic.main.activity_chrapka_wyniki.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.sql.DriverManager


class ChrapkaWyniki : AppCompatActivity() {
    private lateinit var adapter : PrzepisAdapter
    private var przepis: ArrayList<PrzepisElement>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrapka_wyniki)

        supportActionBar?.hide()

        val adres = "jdbc:mysql://195.78.66.225/moodfood_test"
        val user = "moodfood_visor"
        val pass = "MoodFood69"

        val wybraneSkladniki = ArrayList<String>()

        przepis = ArrayList()

//        val nazwyPrzepisow = ArrayList<String>()
//        val opisPrzepisow = ArrayList<String>()
//        val ikonaPrzepisow = ArrayList<Int>()
//        val tloPrzepisow = ArrayList<Int>()



        val wyniki = intent.getParcelableArrayListExtra<SkladnikArray>("Skladniki")

        if (wyniki != null) {
            for (i in 0 until wyniki.size) {
                if (wyniki[i].checked)
                    wyniki[i].getNazwa()?.let { wybraneSkladniki.add(it) }
            }
        }


        MainScope().launch {
            withContext(Dispatchers.Default) {
                try {
                    Class.forName("com.mysql.jdbc.Driver")
                    val con = DriverManager.getConnection(adres, user, pass)
                    val st = con.createStatement()
                    val wynik = st.executeQuery("select DISTINCT przepisy.nazwa, przepisy.shortOpis from przepisy, skladniki, przepisy_skladniki where przepisy.id = przepisy_skladniki.idPrzepisu AND " +
                            "skladniki.id = przepisy_skladniki.idSkladnika AND skladniki.nazwa in (${makeCommand(wybraneSkladniki)})")
                    println(makeCommand(wybraneSkladniki))
                    while (wynik.next()) {
                        przepis!!.add(PrzepisElement(R.drawable.cuttlery, R.drawable.jajecznica, wynik.getString(1), wynik.getString(2)))
                    }
                    con.close()
                } catch (e: Exception) {
                    println("BLAD:")
                    println(e.message)
                    przepis!!.add(PrzepisElement(R.drawable.cuttlery, R.drawable.jajecznica, "ERROR", "ERROR"))
                }
            }

            adapter = PrzepisAdapter(przepis!!)

            przepis_recycler_view.adapter = adapter
            przepis_recycler_view.layoutManager = LinearLayoutManager(this@ChrapkaWyniki)
            przepis_recycler_view.setHasFixedSize(true)
            adapter.notifyDataSetChanged()

        }

    }

    private fun makeCommand(tab: ArrayList<String>) : String {
        var komenda = ""
        for (i in 0 until tab.size) {
            if (i == 0)
                komenda = "'${tab[i]}'"
            else
                komenda += ", '${tab[i]}'"
        }
        return komenda
    }

}

