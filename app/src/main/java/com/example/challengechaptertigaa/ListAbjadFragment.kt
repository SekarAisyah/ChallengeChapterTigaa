package com.example.challengechaptertigaa


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengechaptertigaa.databinding.FragmentListAbjadBinding

class ListAbjadFragment : Fragment(), AbjadAdapter.OnItemClickListener {

    private lateinit var binding: FragmentListAbjadBinding
    private lateinit var adapter: AbjadAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentListAbjadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val abjadList = generateAbjadList()
        adapter = AbjadAdapter(abjadList, this)
        binding.recyclerViewAbjad.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewAbjad.adapter = adapter
    }

    override fun onItemClick(abjad: String) {
        val action = ListAbjadFragmentDirections.actionListAbjadFragmentToListKataFragment(abjad)
        findNavController().navigate(action)

    }
    override fun onKataItemClick(kata: String) {
        Log.d(TAG, "Kata '$kata' di-klik")
    }

    private fun generateAbjadList(): List<ListAbjad> {
        val list = mutableListOf<ListAbjad>()
        // ganti dengan logika untuk menghasilkan daftar abjad
        list.addAll(listOf(ListAbjad("A"), ListAbjad("B"), ListAbjad("C")))
        return list
    }


}
