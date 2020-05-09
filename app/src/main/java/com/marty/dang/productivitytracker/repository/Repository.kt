package com.marty.dang.productivitytracker.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData

/**
 *   Created by Marty Dang on 4/26/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
class Repository(private val dao:ActivityDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allActivities: LiveData<MutableList<Activity>> = dao.getAlphabetizedWords()

    @WorkerThread
    fun insert(activity: Activity){
        dao.insert(activity)
    }

    @WorkerThread
    fun update(activity: Activity) {
        dao.updateActivities(activity)
    }

    @WorkerThread
    fun delete(activity: Activity){
        dao.deleteActivities(activity)
    }

}