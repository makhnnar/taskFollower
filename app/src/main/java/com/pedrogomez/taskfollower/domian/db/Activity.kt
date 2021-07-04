package com.pedrogomez.taskfollower.domian.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity")
data class Activity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "assigned_time")
    var price:Int,
    @ColumnInfo(name = "is_progress")
    var isProgress:Boolean,
)