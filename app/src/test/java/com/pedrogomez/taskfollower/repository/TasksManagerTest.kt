package com.pedrogomez.taskfollower.repository

import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class TasksManagerTest {

    private val TASK: TaskVM = TaskVM()

    private val ID: Long = 1

    private lateinit var SUT : TasksManager

    @Mock
    lateinit var DBMock: DBRepository

    @Mock
    lateinit var DSMock: DSRepository

    @Before
    fun setUp() {
        SUT = TasksManager(
            DBMock,
            DSMock
        )
    }

    @Test
    fun deleteSelected() {
        runBlocking {
            successTaskId()
            SUT.deleteSelected()
            verify(DSMock).selectedTaskId()
            verify(DBMock).deleteTaskById(ID)
        }
    }

    suspend fun successTaskId(){
        Mockito.`when`(DSMock.selectedTaskId()).thenReturn(ID)
    }

    @Test
    fun setSelected() {
    }

    @Test
    fun selected() {
    }

    @Test
    fun tasks() {
    }

    @Test
    fun addTask() {
    }

    @Test
    fun updateTask() {
    }

    @Test
    fun deleteTask() {
    }
}