package com.pedrogomez.taskfollower.repository.datastore

import kotlinx.coroutines.flow.Flow

interface LocalDataStore {

    val selectedTaskId: Flow<Long>

    suspend fun setSelectedTaskId(selectedTaskId: Long)

}