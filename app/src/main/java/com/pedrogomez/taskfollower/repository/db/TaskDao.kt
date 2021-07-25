package com.pedrogomez.taskfollower.repository.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY position ASC")
    fun taks():LiveData<List<TaskDBM>>

    @Insert
    suspend fun insertTask(activity: TaskDBM)

    @Update
    suspend fun updateTask(activity: TaskDBM)

    @Delete
    suspend fun deleteTask(activity: TaskDBM)

}