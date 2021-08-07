package com.pedrogomez.taskfollower.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import com.pedrogomez.taskfollower.utils.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class TasksManagerTest {

    private val TASK: TaskVM = TaskVM()

    private val LIST = listOf(
        TASK
    )

    private val LDLIST : LiveData<List<TaskVM>> = MutableLiveData(
        LIST
    )

    private val ID: Long = 1

    private lateinit var SUT : TasksManager

    @Mock
    lateinit var DBMock: DBRepository

    @Mock
    lateinit var DSMock: DSRepository

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

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

    @Test
    fun setSelected() {
        runBlocking {
            SUT.setSelected(ID)
            verify(DSMock).setSelectedTaskId(ID)
        }
    }

    @Test
    fun selected() {
        runBlocking {
            successTaskId()
            SUT.selected()
            verify(DSMock).selectedTaskId()
            verify(DBMock).getTaskById(ID)
        }
    }

    @Test
    fun tasks() {
        runBlocking {
            successTaskList()
            val result = SUT.tasks()
            verify(DBMock).tasks()
            assertEquals(
                result.getOrAwaitValue(),
                LDLIST.getOrAwaitValue()
            )
        }
    }

    @Test
    fun addTask() {
        runBlocking {
            SUT.addTask(TASK)
            verify(DBMock).addTask(TASK)
        }
    }

    @Test
    fun updateTask() {
        runBlocking {
            SUT.updateTask(TASK)
            verify(DBMock).updateTask(TASK)
        }
    }

    @Test
    fun deleteTask() {
        runBlocking {
            SUT.deleteTask(TASK)
            verify(DBMock).deleteTask(TASK)
        }
    }

    suspend fun successTaskId(){
        Mockito.`when`(DSMock.selectedTaskId()).thenReturn(ID)
    }

    fun successTaskList(){
        Mockito.`when`(DBMock.tasks()).thenReturn(LDLIST)
    }
}