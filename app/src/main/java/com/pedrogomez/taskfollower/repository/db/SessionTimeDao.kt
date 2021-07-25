package com.pedrogomez.taskfollower.repository.db

import androidx.room.*
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM

@Dao
interface SessionTimeDao {

    @Insert
    suspend fun insertNewCategory(dailyTimeDBM: DailyTimeDBM) : Long

    @Insert
    suspend fun insertNewValue(sessionTimeDBM: SessionTimeDBM) : Long

    @Insert
    suspend fun insertNewCar(activity: TaskDBM) : Long

    @Update
    suspend fun updateValue(sessionTimeDBM: SessionTimeDBM)

    @Update
    suspend fun updateCar(activity: TaskDBM)

}