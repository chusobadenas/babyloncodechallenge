package com.jesusbadenas.babyloncodechallenge.entities.mappers

import com.jesusbadenas.babyloncodechallenge.domain.common.Mapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.CommentEntity
import com.jesusbadenas.babyloncodechallenge.entities.Comment
import javax.inject.Inject

class CommentEntityMapper
@Inject
constructor() : Mapper<CommentEntity, Comment>() {

    override fun mapFrom(from: CommentEntity): Comment = Comment(
        from.postId,
        from.id,
        from.body
    )

    override fun mapFrom(from: List<CommentEntity>): List<Comment> {
        val commentCollection: ArrayList<Comment> = ArrayList()

        if (from.isNotEmpty()) {
            for (commentEntity in from) {
                commentCollection.add(mapFrom(commentEntity))
            }
        }

        return commentCollection
    }
}
