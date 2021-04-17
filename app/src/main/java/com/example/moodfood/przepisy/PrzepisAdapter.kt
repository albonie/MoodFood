package com.example.moodfood.przepisy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.moodfood.R
import kotlinx.android.synthetic.main.przepis_item.view.*

class PrzepisAdapter(private val przepisList : List<PrzepisElement>) : RecyclerView.Adapter<PrzepisAdapter.PrzepisViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrzepisViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.przepis_item, parent, false)
        return PrzepisViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PrzepisViewHolder, position: Int) {
        val currentItem = przepisList[position]

        holder.ikonaPrzepisu.setImageResource(currentItem.ikonaPrzepisu)
        holder.tloPrzepisu.setImageResource(currentItem.tloPrzepisu)
        holder.opisPrzepisu.text = currentItem.opisPrzepisu
        holder.tytulPrzepisu.text = currentItem.tytulPrzepisu

    }

    override fun getItemCount() = przepisList.size

    class PrzepisViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tloPrzepisu: ImageView = itemView.tloPrzepisu
        val ikonaPrzepisu: ImageView = itemView.ikonaPrzepisu
        val tytulPrzepisu: TextView = itemView.tytulPrzepisu
        val opisPrzepisu: TextView = itemView.opisPrzepisu


    }

}