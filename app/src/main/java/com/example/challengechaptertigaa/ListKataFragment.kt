package com.example.challengechaptertigaa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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

        // Mengambil argumen abjad dari navigasi
        abjad = ListKataFragmentArgs.fromBundle(requireArguments()).abjad

        // Membuat daftar kata berdasarkan abjad
        val kataList = generateKataList(abjad)

        // set adapter untuk RecyclerView
        adapter = KataAdapter(kataList, this)
        binding.recyclerViewKataa.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewKataa.adapter = adapter
    }

    private fun generateKataList(abjad: String): List<ListKata> {
        val list = mutableListOf<ListKata>()
        when (abjad) {
            "A" -> list.addAll(listOf(ListKata("Angsa"), ListKata("Anggur"), ListKata("Apel")))
            "B" -> list.addAll(listOf(ListKata("Bunda"), ListKata("Bubur Ayam"), ListKata("Bali")))
            "C" -> list.addAll(listOf(ListKata("Cacing"), ListKata("Cumi Cumi"), ListKata("Cake")))
            "D" -> list.addAll(listOf(ListKata("Dadu"), ListKata("Dunia"), ListKata("Durian")))
            "E" -> list.addAll(listOf(ListKata("Elang"), ListKata("Emas"), ListKata("Egg")))
            "F" -> list.addAll(listOf(ListKata("Faris"), ListKata("Farenheit"), ListKata("France")))
            "G" -> list.addAll(listOf(ListKata("Gajah"), ListKata("Gelang"), ListKata("Gurita")))
            "H" -> list.addAll(listOf(ListKata("Harimau"), ListKata("Human"), ListKata("Hitam")))
            "I" -> list.addAll(listOf(ListKata("Itik"), ListKata("Ibu"), ListKata("Ide")))
            "J" -> list.addAll(listOf(ListKata("Jerapah"), ListKata("Jeruk"), ListKata("Jangkrik")))
            "K" -> list.addAll(listOf(ListKata("Kuman"), ListKata("Kerbau"), ListKata("Kebel")))
            "L" -> list.addAll(listOf(ListKata("Lemon"), ListKata("Leci"), ListKata("Lumba-Lumba")))
            "M" -> list.addAll(listOf(ListKata("Marmut"), ListKata("Macan"), ListKata("Mama")))
            "N" -> list.addAll(listOf(ListKata("Nadi"), ListKata("Nenek"), ListKata("New York")))
            "O" -> list.addAll(listOf(ListKata("Orange"), ListKata("Octopus"), ListKata("Oman")))
            "P" -> list.addAll(listOf(ListKata("Paris"), ListKata("Papan"), ListKata("Panci")))
            "Q" -> list.addAll(listOf(ListKata("Qatar"), ListKata("Queen"), ListKata("Quokka")))
            "R" -> list.addAll(listOf(ListKata("Rusia"), ListKata("Rumah"), ListKata("Ratu")))
            "S" -> list.addAll(listOf(ListKata("Strawberri"), ListKata("Sisir"), ListKata("Sahur")))
            "T" -> list.addAll(listOf(ListKata("Turki"), ListKata("Tiger"), ListKata("Tapir")))
            "U" -> list.addAll(listOf(ListKata("Uganda"), ListKata("Ubur Ubur"), ListKata("Uang")))
            "V" -> list.addAll(listOf(ListKata("Vietnam"), ListKata("Vampire"), ListKata("Venezuela")))
            "W" -> list.addAll(listOf(ListKata("Whale"), ListKata("Washington"), ListKata("Wolf")))
            "X" -> list.addAll(listOf(ListKata("X-ray fish"), ListKata("Xylophone"), ListKata("Xenon")))
            "Y" -> list.addAll(listOf(ListKata("Yemen"), ListKata("Yak"), ListKata("York")))
            "Z" -> list.addAll(listOf(ListKata("Zebra"), ListKata("Zimbabwe"), ListKata("Zambia")))
        }
        return list
    }

    override fun onItemClick(kata: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=$kata"))
        startActivity(intent)
    }
}
