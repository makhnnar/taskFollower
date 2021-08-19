package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.DataManager
import kotlinx.coroutines.launch

class TaskViewModel(
    private val dataManager: DataManager
) : ViewModel() {

    fun task() = dataManager.tasks()

    fun createNewTask(){
        viewModelScope.launch {
            dataManager.setSelected(0)
        }
    }

    fun setSelected(id: Long) {
        viewModelScope.launch {
            dataManager.setSelected(id)
        }
    }

}