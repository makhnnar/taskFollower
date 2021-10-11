package com.pedrogomez.taskfollower.repository.datastore

import android.content.Context
import androidx.core.content.edit

class TaskDataStore(
    val context: Context
):DSRepository {

    private val USER_PREFERENCES_NAME = "user_preferences"

    private val sharedPreferences =
        context.applicationContext.getSharedPreferences(
            USER_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )

    private object PreferencesKeys {
        val SELECTED_TASK_ID = "selected_task_id"
    }

    override fun selectedTaskId(): Long{
        return sharedPreferences.getLong(
            PreferencesKeys.SELECTED_TASK_ID,
            0
        )
    }

    override suspend fun setSelectedTaskId(selectedTaskId: Long) {
        sharedPreferences.edit {
            putLong(
                PreferencesKeys.SELECTED_TASK_ID,
                selectedTaskId
            )
        }
    }

}