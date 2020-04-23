package com.marty.dang.productivitytracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.marty.dang.productivitytracker.repository.Entry
import com.marty.dang.productivitytracker.repository.Repo


class ActivityEntryFragment : Fragment(){

    private lateinit var categoryField: EditText
    private lateinit var timeField: EditText
    private lateinit var addButton: Button

    private val addButtonOnClickListener = View.OnClickListener {
        Repo.addData(Entry(categoryField.text.toString(), timeField.text.toString()))
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
