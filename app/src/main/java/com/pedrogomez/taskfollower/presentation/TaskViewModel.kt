package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.db.RepositoryContract

class TaskViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

    val selectedTask = MutableLiveData<TaskVM?>()

    fun task() = contract.tasks()

    fun createNewTask(){
        selectedTask.value = null
    }

}