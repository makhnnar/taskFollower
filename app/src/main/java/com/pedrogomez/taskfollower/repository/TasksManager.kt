package com.pedrogomez.taskfollower.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.CoroutineDispatcher

class TasksManager(
    private val DB: DBRepository,
    private val DS: DSRepository
) : DataManager {

    override suspend fun deleteSelected() {
         DB.deleteTaskById(
             DS.selectedTaskId()
         )
    }

    override suspend fun setSelected(id: Long) {
         
    }

    override fun selected(): LiveData<TaskVM> {
         return MutableLiveData()
    }

    override fun tasks(): LiveData<List<TaskVM>> {
        return MutableLiveData()
    }

    override suspend fun addTask(taskVM: TaskVM) {
         
    }

    override suspend fun updateTask(taskVM: TaskVM) {
         
    }

    override suspend fun deleteTask(taskVM: TaskVM) {
         
    }

}