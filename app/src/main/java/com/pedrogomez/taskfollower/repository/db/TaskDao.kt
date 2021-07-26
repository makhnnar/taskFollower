package com.pedrogomez.taskfollower.repository.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.db.SessionTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM

@Dao
interface TaskDao {

    @Query("SELECT * FROM task ORDER BY position ASC")
    fun taks():LiveData<List<TaskDBM>>

    @Query("SELECT * FROM task WHERE id=:id")
    fun getTaskById(id:Long) : LiveData<TaskDBM>

    @Insert
    suspend fun insertTask(activity: TaskDBM)

    @Update
    suspend fun updateTask(activity: TaskDBM)

    @Delete
    suspend fun deleteTask(activity: TaskDBM)

}