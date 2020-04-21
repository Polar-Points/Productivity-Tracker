package com.marty.dang.productivitytracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.stats_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val entry1 = Entry("Eating", "3 hours")
        val entry2 = Entry("Drinking", "4 hours")
        recyclerView.adapter = StatsAdapter(listOf(entry1, entry2))
        return view
    }
}
