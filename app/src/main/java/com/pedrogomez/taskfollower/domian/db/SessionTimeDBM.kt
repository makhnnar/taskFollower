package com.pedrogomez.taskfollower.domian.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "session_time")
data class SessionTimeDBM(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        val id:Long,
        @ColumnInfo(name = "id_daily_time")
        val idDailyTime:Long,
        @ColumnInfo(name = "start_time")
        val startTime:Long,
        @ColumnInfo(name = "end_time")
        var endTime:Long = 0
)