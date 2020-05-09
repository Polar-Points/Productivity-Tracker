package com.marty.dang.productivitytracker.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.marty.dang.productivitytracker.R
import com.marty.dang.productivitytracker.presentation.viewmodels.HomeFragViewModel
import com.marty.dang.productivitytracker.repository.Activity


class ActivityEntryFrag : Fragment(){

    private val viewModel: HomeFragViewModel by activityViewModels()

    private lateinit var categoryField: EditText
    private lateinit var timeField: EditText
    private lateinit var addButton: Button

    private val addButtonOnClickListener = View.OnClickListener {
        viewModel.insert(Activity(categoryField.text.toString(), timeField.text.toString()))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_entry_fragment, container, false)
        categoryField = view.findViewById(R.id.category_edit_text)
        timeField = view.findViewById(R.id.time_edit_text)
        addButton = view.findViewById(R.id.add_activity_button)
        addButton.setOnClickListener(addButtonOnClickListener)
        return view
    }

}
