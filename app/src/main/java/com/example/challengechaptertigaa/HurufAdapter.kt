package com.example.challengechaptertigaa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HurufAdapter(private val hurufList: List<Char>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HurufAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(huruf: Char)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtAbjad: TextView = itemView.findViewById(R.id.txtAbjad)

        fun bind(huruf: Char) {
            txtAbjad.text = huruf.toString()

            itemView.setOnClickListener {
                listener.onItemClick(huruf)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_huruf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hurufList[position])
    }

    override fun getItemCount(): Int {
        return hurufList.size
    }


}