package com.example.moodfood


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import com.example.moodfood.chrapka.CustomAdapter
import com.example.moodfood.chrapka.DataModel
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
        dataModel!!.add(DataModel("Apple Pie", false))
        dataModel!!.add(DataModel("Banana Bread", false))
        dataModel!!.add(DataModel("Cupcake", false))
        dataModel!!.add(DataModel("Donut", true))
        dataModel!!.add(DataModel("Eclair", true))
        dataModel!!.add(DataModel("Froyo", true))
        dataModel!!.add(DataModel("Gingerbread", true))
        dataModel!!.add(DataModel("Honeycomb", false))
        dataModel!!.add(DataModel("Ice Cream Sandwich", false))
        dataModel!!.add(DataModel("Jelly Bean", false))
        dataModel!!.add(DataModel("Kitkat", false))
        dataModel!!.add(DataModel("Lollipop", false))
        dataModel!!.add(DataModel("Marshmallow", false))
        dataModel!!.add(DataModel("Nougat", false))
        adapter = CustomAdapter(dataModel!!, applicationContext)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val dataModel: DataModel = dataModel!![position]
            dataModel.checked = !dataModel.checked
            adapter.notifyDataSetChanged()
        }
    }
}