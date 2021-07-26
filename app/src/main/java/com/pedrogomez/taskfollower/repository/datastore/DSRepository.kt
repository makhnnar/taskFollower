package com.pedrogomez.taskfollower.repository.datastore

import kotlinx.coroutines.flow.Flow

interface DSRepository {

    val selectedTaskId: Flow<Long>

    suspend fun setSelectedTaskId(selectedTaskId: Long)

}