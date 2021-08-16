package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.DataManager
import kotlinx.coroutines.launch

class TaskViewModel(
    private val dataManager: DataManager
) : ViewModel() {

    val selectedTask = MutableLiveData<TaskVM?>()

    fun task() = dataManager.tasks()

    fun createNewTask(){
        viewModelScope.launch {

        }
        selectedTask.value = null
    }

    fun setSelected(id: Long) {
        viewModelScope.launch {
            dataManager.setSelected(id)
        }
    }

}