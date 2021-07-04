package com.pedrogomez.taskfollower.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pedrogomez.taskfollower.domian.db.Activity
import com.pedrogomez.taskfollower.domian.db.DailyTime
import com.pedrogomez.taskfollower.domian.db.SessionTime

@Database(entities = [Activity::class, DailyTime::class, SessionTime::class], version = 1)
abstract class ActivitiesDB : RoomDatabase() {

    abstract fun activities() : ActivityDao

    abstract fun dailyTimes() : DailyTimeDao

    abstract fun sessionTimes() : SessionTimeDao

}