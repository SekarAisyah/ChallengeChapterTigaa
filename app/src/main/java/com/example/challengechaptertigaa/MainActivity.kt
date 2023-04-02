package com.example.challengechaptertigaa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), HurufAdapter.OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HurufAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rvHuruf)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = HurufAdapter(generateHurufList(), this)
        recyclerView.adapter = adapter

    }

    override fun onItemClick(huruf: String) {
        val fragment = ListKataFragment.newInstance(huruf)
        supportFragmentManager.beginTransaction()
            .replace(R.id.rvHuruf, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun generateHurufList(): List<ListHuruf> {
        val list = mutableListOf<ListHuruf>()
        // ganti dengan logika untuk menghasilkan daftar abjad
        list.addAll(listOf(
            ListHuruf("A"),
            ListHuruf("B"),
            ListHuruf("C"),
            ListHuruf("D"),
            ListHuruf("E"),
            ListHuruf("F"),
            ListHuruf("G"),
            ListHuruf("H"),
            ListHuruf("I"),
            ListHuruf("J"),
            ListHuruf("K"),
            ListHuruf("L"),
            ListHuruf("M"),
            ListHuruf("N"),
            ListHuruf("O"),
            ListHuruf("P"),
            ListHuruf("Q"),
            ListHuruf("R"),
            ListHuruf("S"),
            ListHuruf("T"),
            ListHuruf("U"),
            ListHuruf("V"),
            ListHuruf("W"),
            ListHuruf("X"),
            ListHuruf("Y"),
            ListHuruf("Z")


        ))
        return list
    }

}
