package com.pedrogomez.taskfollower.domian.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_time")
data class DailyTime(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id:Long,
    @ColumnInfo(name = "id_activity")
    val idActivity:Long,
    @ColumnInfo(name = "date")
    val date:Long,
    @ColumnInfo(name = "spended_time")
    var spendedTime:Long = 0
)