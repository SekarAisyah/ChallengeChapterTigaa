package com.example.challengechaptertigaa

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ListKataFragment : Fragment() {

    private lateinit var rvWord: RecyclerView

    companion object {
        private const val ARG_WORD_LIST = "word_list"

        fun newInstance(kataList: List<String>): ListKataFragment {
            val args = Bundle().apply {
                putStringArrayList(ARG_WORD_LIST, ArrayList(kataList))
            }
            val fragment = ListKataFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list_kata, container, false)
        rvWord = view.findViewById(R.id.recycler_view_kataa)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val kataList = arguments?.getStringArrayList(ARG_WORD_LIST) ?: emptyList<String>()
        val kataAdapter = KataAdapter(kataList)
        rvWord.adapter = kataAdapter
        rvWord.layoutManager = LinearLayoutManager(activity)
    }


}
