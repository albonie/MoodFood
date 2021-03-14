package com.example.moodfood


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.moodfood.chrapka.CustomAdapter
import com.example.moodfood.chrapka.DataModel
import com.example.moodfood.chrapka.SkladnikArray
import kotlinx.android.synthetic.main.activity_chrapka.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.sql.DriverManager
import kotlin.collections.ArrayList

class Chrapka : AppCompatActivity() {
    private var dataModel: ArrayList<DataModel>? = null
    private lateinit var listView: ListView
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrapka)



        val adres = "jdbc:mysql://10.0.2.2/moodfood?useUnicode=yes&characterEncoding=UTF-8"
        val dane = "root"



        listView = findViewById<View>(R.id.listView) as ListView
        dataModel = ArrayList()



        val tablicaSkladnikow = ArrayList<SkladnikArray>()

        MainScope().launch {
            withContext(Dispatchers.Default) {


                try {
                    Class.forName("com.mysql.jdbc.Driver")
                    val con = DriverManager.getConnection(adres, dane, dane)
                    val st = con.createStatement()
                    val wyniki = st.executeQuery("select nazwa from skladniki")
                    var i = 0
                    while (wyniki.next()) {

                        tablicaSkladnikow.add(SkladnikArray(wyniki.getString(1), false))

                        dataModel!!.add(DataModel(wyniki.getString(1), false))
                        i++
                    }
                    con.close()
                } catch (e: Exception) {
                    println(e.message)
                }

            }

            skladnikInput.addTextChangedListener(object: TextWatcher {
                override fun onTextChanged(s:CharSequence, start:Int, before:Int,
                                           count:Int) {



                    dataModel!!.clear()


                    tablicaSkladnikow.forEach { skladnik ->
                        if (skladnik.getNazwa()?.contains(skladnikInput.text.toString()) == true) {
                            dataModel!!.add(
                                DataModel(
                                    skladnik.getNazwa(),
                                    skladnik.checked
                                )
                            )
                        }
                    }


                    adapter = CustomAdapter(dataModel!!, applicationContext)
                    listView.adapter = adapter
                    listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

                        val dataModel: DataModel = dataModel!![position]

                        dataModel.checked = !dataModel.checked

                        tablicaSkladnikow.forEach { skladnik ->
                            if (skladnik.getNazwa() == dataModel.name) {
                                skladnik.checked = !skladnik.checked
                            }
                        }


                        adapter.notifyDataSetChanged()

                    }

                }
                override fun beforeTextChanged(s:CharSequence, start:Int, count:Int,
                                               after:Int) {}
                override fun afterTextChanged(s: Editable) {}
            })

            adapter = CustomAdapter(dataModel!!, applicationContext)
            listView.adapter = adapter
            listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                val dataModel: DataModel = dataModel!![position]
                dataModel.checked = !dataModel.checked

                tablicaSkladnikow.forEach { skladnik ->
                    if (skladnik.getNazwa() == dataModel.name) {
                        skladnik.checked = !skladnik.checked
                    }
                }

                adapter.notifyDataSetChanged()

            }
        }

        zobaczPrzepisy.setOnClickListener {
            val intent = Intent(this, ChrapkaWyniki::class.java)
            intent.putExtra("Skladniki", tablicaSkladnikow)
            startActivity(intent)
        }

    }
}

