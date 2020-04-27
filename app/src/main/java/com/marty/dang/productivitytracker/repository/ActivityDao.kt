package com.marty.dang.productivitytracker.repository

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 *   Created by Marty Dang on 4/26/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */

/**
 * The Room Magic is in this file, where you map a Java method call to an SQL query.
 *
 * When you are using complex data types, such as Date, you have to also supply type converters.
 * To keep this example basic, no types that require type converters are used.
 * See the documentation at
 * https://developer.android.com/topic/libraries/architecture/room.html#type-converters
 */

@Dao
interface ActivityDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from activity_table ORDER BY activity ASC")
    fun getAlphabetizedWords(): LiveData<MutableList<Activity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entry: Activity?)

    @Update
    fun updateActivities(vararg activities: Activity)

    @Delete
    fun deleteActivities(vararg activities: Activity)

    @Query("DELETE FROM activity_table")
    fun deleteAll()


}