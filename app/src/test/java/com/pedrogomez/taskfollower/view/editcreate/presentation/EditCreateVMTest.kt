package com.pedrogomez.taskfollower.view.editcreate.presentation

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
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class EditCreateVMTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private val TASK: TaskVM = TaskVM()
    private val TASKTOUPDATE: TaskVM = TaskVM(
        id = 1L
    )

    private val LDTASK : LiveData<TaskVM> = MutableLiveData(
        TASK
    )

    private lateinit var SUT : EditCreateVM

    @Mock
    lateinit var dataManagerMock: DataManager

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this);
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = EditCreateVM(
            dataManagerMock
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun getSelectedTask(){
        runBlocking {
            onSelectedSuccess()
            val selected = SUT.getSelected()
            assertEquals(
                selected.getOrAwaitValue(),
                TASK
            )
        }
    }

    private fun onSelectedSuccess() {
        Mockito.`when`(dataManagerMock.selected()).thenReturn(LDTASK)
    }

    @Test
    fun addTask() {
        runBlocking {
            SUT.addTask(TASK)
            verify(dataManagerMock).addTask(TASK)
        }
    }

    @Test
    fun updateTask() {
        runBlocking {
            SUT.updateTask(TASK)
            verify(dataManagerMock).updateTask(TASK)
        }
    }

    @Test
    fun saveTaskAndUpdate() {
        runBlocking {
            SUT.saveTask(TASKTOUPDATE)
            verify(dataManagerMock).updateTask(TASKTOUPDATE)
        }
    }

    @Test
    fun saveTaskAndAdd() {
        runBlocking {
            SUT.saveTask(TASK)
            verify(dataManagerMock).addTask(TASK)
        }
    }
}