package com.marty.dang.productivitytracker.repository

/**
 *   Created by Marty Dang on 4/22/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
object Repo {

    private val entry1 = Entry(
        "Eating",
        "3 hours"
    )
    private val entry2 = Entry(
        "Drinking",
        "4 hours"
    )

    private var listOfEntries: MutableList<Entry> = mutableListOf(entry1, entry2)

    fun addData(entry: Entry) {
        listOfEntries.add(entry)
    }

    fun getData(): List<Entry>? {
        return listOfEntries
    }
}