package com.pedrogomez.taskfollower.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import com.pedrogomez.taskfollower.repository.DataManager
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    private val TASK: TaskVM = TaskVM()

    private val ID: Long = 1

    private lateinit var SUT : TaskViewModel

    @Mock
    lateinit var DBMock: DataManager

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this);
        Dispatchers.setMain(mainThreadSurrogate)
        SUT = TaskViewModel(
            DBMock
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
            verify(DBMock).setSelected(ID)
        }
    }

    @Test
    fun tasks() {
        runBlocking {
            SUT.task()
            verify(DBMock).tasks()
        }
    }
}