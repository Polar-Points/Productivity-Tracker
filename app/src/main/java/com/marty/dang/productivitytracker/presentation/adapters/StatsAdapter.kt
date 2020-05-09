package com.marty.dang.productivitytracker.presentation.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.marty.dang.productivitytracker.R
import com.marty.dang.productivitytracker.repository.Activity
import timber.log.Timber


/**
 *   Created by Marty Dang on 4/20/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
class StatsAdapter: RecyclerView.Adapter<StatsAdapter.ViewHolder>() {

    private var dataSet = mutableListOf<Activity>()

    /**
     * Provide a reference to the type of views that you are using (custom ViewHolder)
     */
    inner class ViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val category: TextView = v.findViewById(R.id.category)
        val hours: TextView = v.findViewById(R.id.hours)
        init {
            v.setOnClickListener { Log.d("DFD", "Element $adapterPosition clicked.") }
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
        val current = dataSet[position]
        holder.category.text = current.activity
        holder.hours.text = current.duration
    }

    fun getActivityAt(position: Int): Activity{
        return dataSet[position]
    }


    fun setWords(entries: MutableList<Activity>) {
        dataSet = entries
        notifyDataSetChanged()
    }


    fun removeAt(viewHolder: RecyclerView.ViewHolder, recyclerView: RecyclerView) {

        val adapterPosition = viewHolder.adapterPosition
        val entry = dataSet?.get(adapterPosition)

        val snackbar: Snackbar = Snackbar.make(
                recyclerView,
                "Hey Fix it!",
                Snackbar.LENGTH_LONG
            )
            .setAction("Undo", View.OnClickListener {
                if (entry != null) {
                    dataSet.add(adapterPosition, entry)
                }
                notifyItemInserted(adapterPosition)
                recyclerView.scrollToPosition(adapterPosition)
            })
        snackbar.show()
        dataSet.removeAt(adapterPosition)
        notifyItemRemoved(viewHolder.adapterPosition)
    }
}