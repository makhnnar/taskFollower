package com.pedrogomez.taskfollower.view.editcreate.presentation

import kotlinx.coroutines.*
import java.io.Closeable
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.coroutineContext

class AggregateUserDataUseCase(
    private val resolveCurrentUser: suspend () -> UserEntity,
    private val fetchUserComments: suspend (UserId) -> List<CommentEntity>,
    private val fetchSuggestedFriends: suspend (UserId) -> List<FriendEntity>
) : Closeable {

    lateinit var userFriends: Deferred<List<FriendEntity>>

    lateinit var userComments: Deferred<List<CommentEntity>>

    lateinit var allUserData: Deferred<AggregatedData>

    suspend fun aggregateDataForCurrentUser(): AggregatedData = coroutineScope {
        val user = resolveCurrentUser.invoke()
        println(user)
        allUserData = async {
            userComments = async {
                try {
                    fetchUserComments(
                        user.id
                    )
                } catch (e: Exception) {
                    listOf<CommentEntity>()
                }
            }
            userFriends = async {
                try {
                    fetchSuggestedFriends(
                        user.id
                    )
                } catch (e: Exception) {
                    listOf<FriendEntity>()
                }
            }
            val allData = AggregatedData(
                user,
                userComments.await(),
                userFriends.await()
            )
            return@async allData
        }
        allUserData.await()
    }

    override fun close() {
        userComments.cancel()
        userFriends.cancel()
    }
}

data class AggregatedData(
    val user: UserEntity,
    val comments: List<CommentEntity>,
    val suggestedFriends: List<FriendEntity>
)

typealias UserId = String

data class UserEntity(val id: UserId, val name: String)

data class CommentEntity(val id: String, val content: String)

data class FriendEntity(val id: String, val name: String)

