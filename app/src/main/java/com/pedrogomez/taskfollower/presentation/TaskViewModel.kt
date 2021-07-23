package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.domian.view.FormState
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.RepositoryContract
import kotlinx.coroutines.launch

class TaskViewModel(
    private val contract: RepositoryContract
) : ViewModel() {

    private val _taskForm = MutableLiveData<FormState>()
    val taskFormState =  MutableLiveData<FormState>()

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

    fun taskDataChanged(
        name:String?,
        assignedTime:String?,
        isProgress:Boolean
    ) {
        if (!isValidField(name)) {
            taskFormState.value = FormState(
                nameError = R.string.invalid_name
            )
        } else if (!isValidField(assignedTime)) {
            taskFormState.value = FormState(
                timeError = R.string.invalid_time
            )
        } else {
            taskFormState.value = FormState(isDataValid = true)
            //todo: perform update or save
        }
    }

    private fun isValidField(value: String?): Boolean {
        return value!=null && value.isNotEmpty()
    }

}