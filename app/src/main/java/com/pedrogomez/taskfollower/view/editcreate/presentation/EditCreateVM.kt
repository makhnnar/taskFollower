package com.pedrogomez.taskfollower.view.editcreate.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.domian.view.FormState
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.db.RepositoryContract
import kotlinx.coroutines.launch

class EditCreateVM(
    private val contract: RepositoryContract
) : ViewModel()  {

    val selectedTask = MutableLiveData<TaskVM?>()

    val taskFormState =  MutableLiveData<FormState>()

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