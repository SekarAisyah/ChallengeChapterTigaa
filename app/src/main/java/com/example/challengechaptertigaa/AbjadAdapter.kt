package com.example.challengechaptertigaa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AbjadAdapter(private val listAbjad: List<ListAbjad>, private val listener: OnItemClickListener) : RecyclerView.Adapter<AbjadAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_abjad, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listAbjad[position])
    }

    override fun getItemCount(): Int {
        return listAbjad.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val tvAbjad: TextView = itemView.findViewById(R.id.tv_item_abjad)

        fun bind(abjad: ListAbjad) {
            tvAbjad.text = abjad.abjad
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(listAbjad[position].abjad)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(abjad: String)
        fun onKataItemClick(kata: String)
    }
}