package com.marty.dang.productivitytracker.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.marty.dang.productivitytracker.repository.Activity
import com.marty.dang.productivitytracker.repository.ActivityDatabase
import com.marty.dang.productivitytracker.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *   Created by Marty Dang on 4/26/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
class HomeFragViewModel(application: Application): AndroidViewModel(application) {

    val activityDao = ActivityDatabase.getDatabase(application, viewModelScope).activityDao()
    val repository = Repository(activityDao)
    val listOfActivities: LiveData<MutableList<Activity>> = repository.allActivities

    fun insert(activity: Activity) {
        viewModelScope.launch(Dispatchers.IO) { repository.insert(activity) }
    }

}