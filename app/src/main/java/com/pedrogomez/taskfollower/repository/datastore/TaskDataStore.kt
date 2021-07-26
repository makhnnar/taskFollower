package com.pedrogomez.taskfollower.repository.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.createDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskDataStore(
    val context: Context
):DSRepository {

    private val dataStore : DataStore<Preferences> = context.createDataStore(
        name = "tasks_store"
    )

    private object PreferencesKeys {
        val SELECTED_TASK_ID = longPreferencesKey("selected_task_id")
    }

    override val selectedTaskId: Flow<Long> = dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.SELECTED_TASK_ID] ?: 0
        }

    override suspend fun setSelectedTaskId(selectedTaskId: Long) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.SELECTED_TASK_ID] = selectedTaskId
        }
    }

}