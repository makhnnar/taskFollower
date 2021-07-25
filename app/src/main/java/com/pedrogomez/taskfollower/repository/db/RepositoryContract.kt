package com.pedrogomez.taskfollower.repository.db

import androidx.lifecycle.LiveData
import com.pedrogomez.taskfollower.domian.db.DailyTimeDBM
import com.pedrogomez.taskfollower.domian.view.TaskVM
/**
 * TODO:
 *  edit carModel with task model
 *  create dailytimemodel and sessiontimemodel
 *  edit carviewmodel for taskviewmodel
 *  create stats detail view model for stats details
 *  create class diagram class for watch more carefully the interdependency between classes
 * */
interface RepositoryContract {

    suspend fun addTask(taskVM: TaskVM)

    suspend fun updateTask(taskVM: TaskVM)

    suspend fun deleteTask(taskVM: TaskVM)

    fun tasks() : LiveData<List<TaskVM>>

}