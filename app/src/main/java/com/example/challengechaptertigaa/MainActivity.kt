package com.example.challengechaptertigaa

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



//Penerapan Single Activity
class MainActivity : AppCompatActivity(), HurufAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView for alphabet list
        val txtAbjad: RecyclerView = findViewById(R.id.rvHuruf)
        val hurufList = ('A'..'Z').toList()
        val hurufAdapter = HurufAdapter(hurufList, this)
        txtAbjad.adapter = hurufAdapter
        txtAbjad.layoutManager = LinearLayoutManager(this)

        // Display initial fragment with empty list
        val initialFragment = ListKataFragment.newInstance(emptyList())
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, initialFragment)
            .commit()
    }

    override fun onItemClick(huruf: Char) {
        // Get word list starting with the selected alphabet
        val kataList = getWordListByHuruf(huruf)

        // Display new fragment with word list
        val fragment = ListKataFragment.newInstance(kataList)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun getWordListByHuruf(huruf: Char): List<String> {
        val kataList = mutableListOf<String>()
        val kata = arrayOf(
            "Apple", "Apricot", "Avocado",
            "Banana", "Blueberry",
            "Cherry", "Coconut",
            "Date", "Dragonfruit", "Durian",
            "Emas","Elang","Egg",
            "Fig","Faris","Farenheit",
            "Grape", "Guava","Gajah",
            "Honeydew","Human","Hitam",
            "Jackfruit","Jerapah","Jangkrik",
            "Kiwi", "Kuala Lumpur","Kangguru",
            "Lemon", "Lime", "Lychee",
            "Mango", "Marmut","Musang",
            "Naga","Nenek","Nadi",
            "Orange","Octopus","Oman",
            "Papaya", "Peach", "Pear", "Pineapple", "Plum", "Pomegranate",
            "Quince","Qatar", "Queen",
            "Raspberry","Rambutan","Ratu",
            "Strawberry", "Salak", "Singa",
            "Tangga","Tiger","Tapir",
            "Undur Undur", "Uang", "Usang",
            "Vineapple",
            "Watermelon",
            "Xigua",
            "Yellow watermelon",
            "Zendaya","Zebra","Zonasi"
        )

        for (word in kata) {
            if (word.startsWith(huruf, ignoreCase = true)) {
                kataList.add(word)
            }
        }

        return kataList
    }


}
