package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.taskfollower.domian.view.TaskVM

interface DataManager {

    suspend fun deleteSelected()

    suspend fun setSelected(id:Long)

    suspend fun selected():LiveData<TaskVM>

    fun tasks():LiveData<List<TaskVM>>

    suspend fun addTask(taskVM: TaskVM)

    suspend fun updateTask(taskVM: TaskVM)

    suspend fun deleteTask(taskVM: TaskVM)

}