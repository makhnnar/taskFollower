package com.pedrogomez.taskfollower.repository.datastore

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.ivanshafran.sharedpreferencesmock.SPMockBuilder
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(AndroidJUnit4::class)
class TaskDataStoreTest {

    private val ID = 1L

    private val spMockBuilder = SPMockBuilder()

    private lateinit var SUT : TaskDataStore

    @Before
    fun setUp() {
        SUT = TaskDataStore(spMockBuilder.createContext())
    }

    @Test
    fun selectedTaskId() {
    }

    @Test
    fun setSelectedTaskId() {
        runBlocking {
            SUT.setSelectedTaskId(ID)
            val result = SUT.selectedTaskId()
            assert(ID==result)
        }
    }
}