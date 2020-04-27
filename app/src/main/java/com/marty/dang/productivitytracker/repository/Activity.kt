package com.marty.dang.productivitytracker.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Created by Marty Dang on 4/26/20
 *   Copyright @ 2019 Dang, Marty. All rights reserved.
 */

/**
 * A basic class representing an entity that is a row in a one-column database table.
 *
 * @ Entity - You must annotate the class as an entity and supply a table name if not class name.
 * @ PrimaryKey - You must identify the primary key.
 * @ ColumnInfo - You must supply the column name if it is different from the variable name.
 *
 * See the documentation for the full rich set of annotations.
 * https://developer.android.com/topic/libraries/architecture/room.html
 */

@Entity(tableName = "activity_table")
data class Activity(
    @field:ColumnInfo(name = "activity")
    @field:PrimaryKey val activity: String,
    var duration: String
)