package com.pedrogomez.taskfollower.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM

@Database(entities = [TaskDBM::class, DailyTimeDBM::class, SessionTimeDBM::class], version = 1)
abstract class TaskDB : RoomDatabase() {

    abstract fun activities() : TaskDao

    abstract fun dailyTimes() : DailyTimeDao

    abstract fun sessionTimes() : SessionTimeDao

}