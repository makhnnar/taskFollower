package com.pedrogomez.taskfollower.repository.datastore

import kotlinx.coroutines.flow.Flow

interface DSRepository {

    fun selectedTaskId():Long

    suspend fun setSelectedTaskId(selectedTaskId: Long)

}