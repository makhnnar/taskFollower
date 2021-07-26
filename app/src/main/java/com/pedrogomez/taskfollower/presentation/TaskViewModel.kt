package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.DataManager
import com.pedrogomez.taskfollower.repository.db.DBRepository

class TaskViewModel(
    private val dataManager: DataManager
) : ViewModel() {

    val selectedTask = MutableLiveData<TaskVM?>()

    fun task() = dataManager.tasks()

    fun createNewTask(){
        selectedTask.value = null
    }

}