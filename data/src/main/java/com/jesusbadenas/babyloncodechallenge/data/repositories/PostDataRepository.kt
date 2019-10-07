package com.jesusbadenas.babyloncodechallenge.data.repositories

import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.entities.mappers.PostDataMapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.PostRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostDataRepository
@Inject
constructor(
    private val apiService: APIService,
    private val postDataMapper: PostDataMapper
) : PostRepository {

    override fun posts(): Observable<List<PostEntity>> {
        return apiService.getPosts().map { postDataList ->
            postDataMapper.transform(postDataList)
        }
    }
}
