package com.jesusbadenas.babyloncodechallenge.data.repositories

import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.entities.mappers.CommentDataMapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.CommentEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.CommentRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentDataRepository
@Inject
constructor(
    private val apiService: APIService,
    private val commentDataMapper: CommentDataMapper
) : CommentRepository {

    override fun comments(postId: Int): Single<List<CommentEntity>> {
        return apiService.getComments()
            .map { commentDataList ->
                commentDataMapper.transform(commentDataList)
            }
            .flatMap { commentEntityList ->
                Observable.fromIterable(commentEntityList)
            }
            .filter { commentEntity ->
                commentEntity.postId == postId
            }
            .toList()
    }

    override fun numberOfComments(postId: Int): Single<Long> {
        return apiService.getComments()
            .map { commentDataList ->
                commentDataMapper.transform(commentDataList)
            }
            .flatMap { commentEntityList ->
                Observable.fromIterable(commentEntityList)
            }
            .filter { commentEntity ->
                commentEntity.postId == postId
            }
            .count()
    }
}
