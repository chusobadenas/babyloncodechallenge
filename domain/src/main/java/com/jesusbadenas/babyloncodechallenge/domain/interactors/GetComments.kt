package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.repositories.CommentRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetComments
@Inject
constructor(private val commentRepository: CommentRepository) : UseCase<Long>() {

    override fun create(data: Map<String, Any>?): Observable<Long> {
        val postId = data?.get("id") as Int
        return commentRepository.numberOfComments(postId).toObservable()
    }
}
