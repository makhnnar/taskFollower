package com.pedrogomez.taskfollower.repository

import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.presentation.TaskViewModel
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
class TasksManagerTest {

    private val TASK: TaskVM = TaskVM()

    private val ID: Long = 1

    private lateinit var SUT : TaskViewModel

    @Mock
    lateinit var DBMock: DBRepository

    @Mock
    lateinit var DSMock: DSRepository

    @Before
    fun setUp() {
        SUT = TaskViewModel(
            DBMock,
            DSMock
        )
    }

    @Test
    fun setSelected() {
        runBlocking {
            SUT.setSelected(ID)
            verify(DBMock).getTaskById(ID)
        }
    }

    @Test
    fun tasks() {
    }
}