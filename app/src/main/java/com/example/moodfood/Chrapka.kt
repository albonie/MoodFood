package com.example.moodfood


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.moodfood.chrapka.CustomAdapter
import com.example.moodfood.chrapka.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.sql.DriverManager
import java.util.*

class Chrapka : AppCompatActivity() {
    private var dataModel: ArrayList<DataModel>? = null
    private lateinit var listView: ListView
    private lateinit var adapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrapka)



                listView = findViewById<View>(R.id.listView) as ListView
                dataModel = ArrayList<DataModel>()

            MainScope().launch {
                withContext(Dispatchers.Default) {
                    val adres = "jdbc:mysql://10.0.2.2/moodfood?useUnicode=yes&characterEncoding=UTF-8"
                    val dane = "root"

                    try {
                        Class.forName("com.mysql.jdbc.Driver")
                        val con = DriverManager.getConnection(adres, dane, dane)
                        val st = con.createStatement()
                        val wyniki = st.executeQuery("select nazwa from skladniki")
                        while (wyniki.next()) {
                            dataModel!!.add(DataModel(wyniki.getString(1), false))
                        }
                        con.close()
                    } catch (e: Exception) {
                        println(e.message)
                        println("EEEEOOOOO")
                    }
                }
                adapter = CustomAdapter(dataModel!!, applicationContext)
                listView.adapter = adapter
                listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
                    val dataModel: DataModel = dataModel!![position]
                    dataModel.checked = !dataModel.checked
                    adapter.notifyDataSetChanged()
                }
            }

    }
}




//         dataModel!!.add(DataModel("Apple Pie", false))
//        dataModel!!.add(DataModel("Banana Bread", false))
//        dataModel!!.add(DataModel("Cupcake", false))
//        dataModel!!.add(DataModel("Donut", true))
//        dataModel!!.add(DataModel("Eclair", true))
//        dataModel!!.add(DataModel("Froyo", true))
//        dataModel!!.add(DataModel("Gingerbread", true))
//        dataModel!!.add(DataModel("Honeycomb", false))
//        dataModel!!.add(DataModel("Ice Cream Sandwich", false))
//        dataModel!!.add(DataModel("Jelly Bean", false))
//        dataModel!!.add(DataModel("Kitkat", false))
//        dataModel!!.add(DataModel("Lollipop", false))
//        dataModel!!.add(DataModel("Marshmallow", false))
//        dataModel!!.add(DataModel("Nougat", false))