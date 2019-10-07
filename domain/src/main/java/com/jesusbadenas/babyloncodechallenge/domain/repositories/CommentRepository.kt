package com.jesusbadenas.babyloncodechallenge.domain.repositories

import com.jesusbadenas.babyloncodechallenge.domain.entities.CommentEntity
import io.reactivex.Single

interface CommentRepository {

    fun comments(postId: Int): Single<List<CommentEntity>>

    fun numberOfComments(postId: Int): Single<Long>
}
