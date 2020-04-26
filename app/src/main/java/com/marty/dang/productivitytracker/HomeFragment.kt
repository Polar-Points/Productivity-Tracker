package com.marty.dang.productivitytracker

import StatsSwipeController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marty.dang.productivitytracker.repository.Repo

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.stats_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val adapter = StatsAdapter(Repo.getData() ?: mutableListOf())
        recyclerView.adapter = adapter

        val itemTouchHelper = ItemTouchHelper(StatsSwipeController(requireActivity(),adapter, recyclerView))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        return view
    }
}
