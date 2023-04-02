package com.example.challengechaptertigaa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class KataAdapter(private val listKata: List<ListKata>, private val listener: OnItemClickListener) : RecyclerView.Adapter<KataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_kata, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listKata[position])
    }

    override fun getItemCount(): Int {
        return listKata.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val tvKata: TextView = itemView.findViewById(R.id.recycler_view_kataa)

        fun bind(kata: ListKata) {
            tvKata.text = kata.kata
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(listKata[position].kata)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(kata: String)
    }
}
