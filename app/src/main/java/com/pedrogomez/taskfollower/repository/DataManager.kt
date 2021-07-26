package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import com.pedrogomez.taskfollower.domian.view.TaskVM

interface DataManager {

    fun deleteSelected()

    fun setSelected(id:Long)

    fun selected():LiveData<TaskVM>

    fun tasks():LiveData<List<TaskVM>>

    suspend fun addTask(taskVM: TaskVM)

    suspend fun updateTask(taskVM: TaskVM)

    suspend fun deleteTask(taskVM: TaskVM)

}