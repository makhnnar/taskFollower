package com.pedrogomez.taskfollower.presentation

import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
import com.pedrogomez.taskfollower.repository.DataManager
import com.pedrogomez.taskfollower.repository.datastore.DSRepository
import com.pedrogomez.taskfollower.repository.db.DBRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class TasksViewModelTest {

    private val TASK: TaskVM = TaskVM()

    private val ID: Long = 1

    private lateinit var SUT : TaskViewModel

    @Mock
    lateinit var DBMock: DataManager

    @Before
    fun setUp() {
        SUT = TaskViewModel(
            DBMock
        )
    }

    @Test
    fun setSelected() {
        runBlocking {

        }
    }

    @Test
    fun tasks() {
    }
}