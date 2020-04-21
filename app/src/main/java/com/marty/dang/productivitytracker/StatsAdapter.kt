package com.marty.dang.productivitytracker

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *   Created by Marty Dang on 4/20/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
class StatsAdapter(private val dataSet: List<Entry>): RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val category: TextView
        val hours: TextView
        init {
            v.setOnClickListener { Log.d("DFD", "Element $adapterPosition clicked.") }
            category = v.findViewById(R.id.category)
            hours = v.findViewById(R.id.hours)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view.
        val v = LayoutInflater.from(parent.context).inflate(R.layout.text_row_item, parent, false)
        return ViewHolder(v)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return dataSet.size
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view
        // with that element
        holder.category.text = dataSet[position].category
        holder.hours.text = dataSet[position].time
    }
}