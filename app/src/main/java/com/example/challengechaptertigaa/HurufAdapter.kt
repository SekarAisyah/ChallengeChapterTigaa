package com.example.challengechaptertigaa

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HurufAdapter(private val hurufList: List<ListHuruf>, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<HurufAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(huruf: String)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val textViewAbjad: TextView = itemView.findViewById(R.id.txtAbjad)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(huruf: ListHuruf) {
            textViewAbjad.text = huruf.huruf
        }

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(hurufList[position].huruf)
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
