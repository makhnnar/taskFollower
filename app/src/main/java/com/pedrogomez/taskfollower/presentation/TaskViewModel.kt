package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.RepositoryContract
import kotlinx.coroutines.launch

class TaskViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

    fun task() = contract.tasks()

    fun addTask(task: TaskVM) {
        viewModelScope.launch {
            contract.addTask(task)
        }
    }

    fun updateTask(task: TaskVM) {
        viewModelScope.launch {
            contract.updateTask(task)
        }
    }

    fun saveCar(task: TaskVM) {
        viewModelScope.launch {
            if(task.id!=0L){
                contract.updateTask(task)
            }else{
                contract.addTask(task)
            }
        }
    }

}