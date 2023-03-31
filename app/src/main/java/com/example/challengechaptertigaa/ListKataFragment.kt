package com.example.challengechaptertigaa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challengechaptertigaa.databinding.FragmentListKataBinding

class ListKataFragment : Fragment(), KataAdapter.OnItemClickListener {

    private lateinit var binding: FragmentListKataBinding
    private lateinit var adapter: KataAdapter
    private lateinit var abjad: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListKataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ambil argumen abjad dari navigasi
        abjad = ListKataFragmentArgs.fromBundle(requireArguments()).abjad

        // buat daftar kata berdasarkan abjad
        val kataList = generateKataList(abjad)

        // set adapter untuk RecyclerView
        adapter = KataAdapter(kataList, this)
        binding.recyclerViewKataa.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewKataa.adapter = adapter
    }

    private fun generateKataList(abjad: String): List<ListKata> {
        val list = mutableListOf<ListKata>()
        when (abjad) {
            "A" -> list.addAll(listOf(ListKata("APPLE"), ListKata("ANT"), ListKata("AIRPLANE")))
            "B" -> list.addAll(listOf(ListKata("banana"), ListKata("bee"), ListKata("ball")))
            "C" -> list.addAll(listOf(ListKata("cat"), ListKata("car"), ListKata("cake")))
            // tambahkan logika untuk abjad lainnya di sini
        }
        return list
    }

    override fun onItemClick(kata: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$kata"))
        startActivity(intent)
    }
}
