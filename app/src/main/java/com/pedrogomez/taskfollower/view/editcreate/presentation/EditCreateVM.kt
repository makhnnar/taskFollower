package com.pedrogomez.taskfollower.view.editcreate.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pedrogomez.taskfollower.R
import com.pedrogomez.taskfollower.domian.view.FormState
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.DataManager
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.launch

class EditCreateVM(
    private val dataManager: DataManager
) : ViewModel()  {

    val taskFormState =  MutableLiveData<FormState>()

    fun  getSelected() = dataManager.selected()

    fun addTask(task: TaskVM) {
        viewModelScope.launch {
            dataManager.addTask(task)
        }
    }

    fun updateTask(task: TaskVM) {
        viewModelScope.launch {
            dataManager.updateTask(task)
        }
    }

    fun saveCar(task: TaskVM) {
        viewModelScope.launch {
            if(task.id!=0L){
                dataManager.updateTask(task)
            }else{
                dataManager.addTask(task)
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