package com.marty.dang.productivitytracker.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *   Created by Marty Dang on 4/26/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */
@Database(entities = [Activity::class], version = 1, exportSchema = true)
abstract class ActivityDatabase: RoomDatabase() {

    abstract fun activityDao(): ActivityDao

    companion object {
        @Volatile
        private var INSTANCE: ActivityDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): ActivityDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActivityDatabase::class.java,
                    "activity_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class WordDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.activityDao())
                    }
                }
            }
        }

        /**
         * Populate the database in a new coroutine.
         * If you want to start with more words, just add them.
         */
        fun populateDatabase(activityDao: ActivityDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            activityDao.deleteAll()

            val activity = Activity("Hello", "World")
            activityDao.insert(activity)
        }
    }
}