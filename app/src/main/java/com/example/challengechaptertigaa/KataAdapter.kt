package com.example.challengechaptertigaa

import android.app.SearchManager
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KataAdapter(private val kataList: List<String>) :
    RecyclerView.Adapter<KataAdapter.KataViewHolder>() {

    class KataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtKata: TextView = itemView.findViewById(R.id.txtHuruf)
        fun bind(kata: String) {
            txtKata.text = kata
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KataViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item_kata,
            parent,
            false
        )
        return KataViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: KataViewHolder, position: Int) {
        val currentWord = kataList[position]
        holder.txtKata.text = currentWord

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY, currentWord)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kataList.size
    }
}
