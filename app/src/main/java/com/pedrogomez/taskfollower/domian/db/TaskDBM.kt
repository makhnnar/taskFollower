package com.pedrogomez.taskfollower.domian.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskDBM(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "assigned_time")
    var price:Int,
    @ColumnInfo(name = "is_progress")
    var isProgress:Boolean,
    @ColumnInfo(name = "is_running")
    var isRunning:Boolean,
    @ColumnInfo(name = "last_time_running")
    var lastTimeRunning:Long,
    @ColumnInfo(name = "position")
    var position:Int,
)