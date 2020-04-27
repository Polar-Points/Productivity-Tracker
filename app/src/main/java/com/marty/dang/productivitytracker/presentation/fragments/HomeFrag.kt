package com.marty.dang.productivitytracker.presentation.fragments

import StatsSwipeController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marty.dang.productivitytracker.R
import com.marty.dang.productivitytracker.presentation.adapters.StatsAdapter
import com.marty.dang.productivitytracker.presentation.viewmodels.HomeFragViewModel
import com.marty.dang.productivitytracker.repository.Activity

class HomeFrag : Fragment() {

    private val viewModel: HomeFragViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        val recyclerView: RecyclerView = view.findViewById(R.id.stats_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        val adapter = StatsAdapter(requireContext())
        recyclerView.adapter = adapter

        viewModel.listOfActivities.observe(viewLifecycleOwner, Observer<MutableList<Activity>>{
            adapter.setWords(it)
        })

        val itemTouchHelper = ItemTouchHelper(StatsSwipeController(requireActivity(),adapter, recyclerView))
        itemTouchHelper.attachToRecyclerView(recyclerView)

        return view
    }
}
