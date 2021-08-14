package com.pedrogomez.taskfollower.repository.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pedrogomez.taskfollower.domian.db.TaskDBM
import com.pedrogomez.taskfollower.domian.mapper.MapperContract
import com.pedrogomez.taskfollower.domian.view.TaskVM
import com.pedrogomez.taskfollower.utils.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class TaskLocalRepoTest {

    private val ID = 1L

    private val TASKVM = TaskVM()

    private val TASKDB = TaskDBM(
        id = ID,
        name = TASKVM.name?:"",
        assignedTime = TASKVM.assignedTime?: 0,
        isProgress = TASKVM.isProgress,
        isRunning = TASKVM.isRunning,
        lastTimeRunning = TASKVM.lastTimeRunning,
        position = TASKVM.position
    )

    private val LIST = listOf(
        TASKDB
    )

    private val LDLISTFDB : LiveData<List<TaskDBM>> = MutableLiveData(
        LIST
    )

    private val LDFDB : LiveData<TaskDBM> = MutableLiveData(
        TASKDB
    )

    private lateinit var SUT : TaskLocalRepo

    @Mock lateinit var taskDaoMock : TaskDao

    @Mock lateinit var mapperContractMock : MapperContract<TaskVM, TaskDBM>

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        SUT = TaskLocalRepo(
            taskDaoMock,
            mapperContractMock
        )
    }

    @Test
    fun addTask() {
        runBlocking {
            successMapFromVMtoDB()
            SUT.addTask(TASKVM)
            verify(mapperContractMock).fromVMtoDB(TASKVM)
            verify(taskDaoMock).insertTask(TASKDB)
        }
    }

    @Test
    fun updateTask() {
        runBlocking {
            successMapFromVMtoDB()
            SUT.updateTask(TASKVM)
            verify(mapperContractMock).fromVMtoDB(TASKVM)
            verify(taskDaoMock).updateTask(TASKDB)
        }
    }

    @Test
    fun deleteTask() {
        runBlocking {
            successMapFromVMtoDB()
            SUT.deleteTask(TASKVM)
            verify(mapperContractMock).fromVMtoDB(TASKVM)
            verify(taskDaoMock).deleteTask(TASKDB)
        }
    }

    @Test
    fun deleteTaskById() {
        runBlocking {
            SUT.deleteTaskById(ID)
            verify(taskDaoMock).deleteTaskByID(ID)
        }
    }

    @Test
    fun tasks() {
        //add missing test for compare return values
        runBlocking {
            successMapFromDBtoVM()
            successListFromDB()
            SUT.tasks().getOrAwaitValue()
            verify(taskDaoMock).taks()
            verify(mapperContractMock).fromDBtoVM(TASKDB)
        }
    }

    @Test
    fun getTaskById() {
        runBlocking {
            successMapFromDBtoVM()
            successFromDBById()
            SUT.getTaskById(ID).getOrAwaitValue()
            verify(taskDaoMock).getTaskById(ID)
            verify(mapperContractMock).fromDBtoVM(TASKDB)
        }
    }

    fun successMapFromVMtoDB(){
        Mockito.`when`(mapperContractMock.fromVMtoDB(TASKVM)).thenReturn(TASKDB)
    }

    fun successMapFromDBtoVM(){
        Mockito.`when`(mapperContractMock.fromDBtoVM(TASKDB)).thenReturn(TASKVM)
    }

    fun successListFromDB(){
        Mockito.`when`(taskDaoMock.taks()).thenReturn(LDLISTFDB)
    }

    fun successFromDBById(){
        Mockito.`when`(taskDaoMock.getTaskById(ID)).thenReturn(LDFDB)
    }

}