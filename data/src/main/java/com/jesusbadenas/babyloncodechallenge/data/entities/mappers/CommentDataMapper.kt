package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.CommentData
import com.jesusbadenas.babyloncodechallenge.domain.entities.CommentEntity
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CommentDataMapper
@Inject
constructor() {
    fun transform(commentData: CommentData): CommentEntity {
        return CommentEntity(commentData.postId, commentData.id, commentData.body)
    }

    fun transform(commentDataCollection: Collection<CommentData>): List<CommentEntity> {
        val commentEntityList = ArrayList<CommentEntity>()
        for (commentData in commentDataCollection) {
            val commentEntity = transform(commentData)
            commentEntityList.add(commentEntity)
        }
        return commentEntityList
    }
}
