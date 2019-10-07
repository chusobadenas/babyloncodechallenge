package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.PostRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetPosts
@Inject
constructor(private val postRepository: PostRepository) : UseCase<List<PostEntity>>() {

    override fun create(data: Map<String, Any>?): Observable<List<PostEntity>> {
        return postRepository.posts()
    }
}
