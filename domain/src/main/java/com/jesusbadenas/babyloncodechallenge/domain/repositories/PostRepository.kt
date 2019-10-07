package com.jesusbadenas.babyloncodechallenge.domain.repositories

import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import io.reactivex.Observable

interface PostRepository {

    fun posts(): Observable<List<PostEntity>>
}
