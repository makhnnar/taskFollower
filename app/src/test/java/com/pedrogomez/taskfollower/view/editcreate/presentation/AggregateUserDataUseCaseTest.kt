package com.pedrogomez.taskfollower.view.editcreate.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.pedrogomez.taskfollower.repository.TasksManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class AggregateUserDataUseCaseTest {

    private lateinit var SUT : AggregateUserDataUseCase

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock lateinit var fetchUserComments: suspend (UserId) -> List<CommentEntity>

    @Mock lateinit var fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>

    @Before
    fun setUp() {
        SUT = AggregateUserDataUseCase(
            {
                UserEntity(
                    "1",
                    "name"
                )
            },
            {
                //listOf<CommentEntity>()
                delay(100)
                throw RuntimeException("Request Failed")
            },
            {
                //listOf<FriendEntity>()
                delay(1000)
                throw RuntimeException("Request Failed")
            }
        )
    }

    @Test
    fun aggregateDataForCurrentUser() {
        runBlocking {
            SUT.aggregateDataForCurrentUser()
        }
    }

    @Test
    fun close() {
    }

}