package com.pedrogomez.taskfollower.view.list.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.repository.DataManager
import com.pedrogomez.taskfollower.utils.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    private val ID: Long = 1

    private lateinit var SUT : TaskViewModel

    private val TASK: TaskVM = TaskVM()

    private val LIST = listOf(
        TASK
    )

    private val LDLIST : LiveData<List<TaskVM>> = MutableLiveData(
        LIST
    )

    @Mock
    lateinit var dataManagerMock: DataManager

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this);
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = TaskViewModel(
            dataManagerMock
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun setSelected() {
        runBlocking {
            SUT.setSelected(ID)
            verify(dataManagerMock).setSelected(ID)
        }
    }

    @Test
    fun tasks() {
        runBlocking {
            onListSuccess()
            var result = SUT.task()
            verify(dataManagerMock).tasks()
            assertEquals(
                result.getOrAwaitValue(),
                LDLIST.getOrAwaitValue()
            )
        }
    }

    @Test
    fun createTask(){
        runBlocking {
            SUT.createNewTask()
            verify(dataManagerMock).setSelected(0)
        }
    }

    fun onListSuccess(){
        Mockito.`when`(dataManagerMock.tasks()).thenReturn(LDLIST)
    }

}