package com.pedrogomez.taskfollower.repository.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.view.TaskVM

class TaskLocalRepo(
    private val activityDao: TaskDao,
    private val mapperContract: MapperContract<TaskVM,TaskDBM>,
) : RepositoryContract {

    override suspend fun addTask(taskVM: TaskVM) {
        activityDao.insertTask(
                mapperContract.fromVMtoDB(taskVM)
        )
    }

    override suspend fun updateTask(taskVM: TaskVM) {
        activityDao.updateTask(
            mapperContract.fromVMtoDB(taskVM)
        )
    }

    override suspend fun deleteTask(taskVM: TaskVM) {
        activityDao.deleteTask(
                mapperContract.fromVMtoDB(taskVM)
        )
    }

    override fun tasks(): LiveData<List<TaskVM>> {
        return activityDao.taks().map {
            it.map { task ->
                mapperContract.fromDBtoVM(task)
            }
        }
    }
}