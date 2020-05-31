package com.example.lab5

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment5.*

class Fragment5 : Fragment() {
    lateinit var recyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment5,container,false)
        recyclerView = view.findViewById(R.id.recyclerView)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = GridLayoutManager(context,1)
        recyclerView.adapter = ListAdapter(arrayListOf("https://i.imgur.com/2KxoIsa.jpg",
            "https://i.imgur.com/EZHXbA0.jpg",
            "https://i.imgur.com/qb7Ev7A.jpg",
            "https://i.imgur.com/ZtXXAwX.jpg",
            "https://i.imgur.com/lrE9vha.jpg",
            "https://i.imgur.com/S66rx9n.jpg"))
    }
}