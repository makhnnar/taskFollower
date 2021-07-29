package com.pedrogomez.taskfollower.presentation

import androidx.lifecycle.*
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TaskViewModel(
    private val DB: DBRepository,
    private val DS : DSRepository
) : ViewModel() {

    val selectedTask = MutableLiveData<TaskVM?>()

    fun task() = DB.tasks()

    fun createNewTask(){
        viewModelScope.launch {
            DS.selectedTaskId.collect {

            }
        }
        selectedTask.value = null
    }

    fun setSelected(id: Long) {

    }

}