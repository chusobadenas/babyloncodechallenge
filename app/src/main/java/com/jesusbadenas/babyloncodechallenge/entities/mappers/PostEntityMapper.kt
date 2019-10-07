package com.jesusbadenas.babyloncodechallenge.entities.mappers

import com.jesusbadenas.babyloncodechallenge.domain.common.Mapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.entities.Post
import javax.inject.Inject

class PostEntityMapper
@Inject
constructor() : Mapper<PostEntity, Post>() {

    override fun mapFrom(from: PostEntity): Post = Post(
        from.userId,
        from.id,
        from.title,
        from.body
    )

    override fun mapFrom(from: List<PostEntity>): List<Post> {
        val postCollection: ArrayList<Post> = ArrayList()

        if (from.isNotEmpty()) {
            for (postEntity in from) {
                postCollection.add(mapFrom(postEntity))
            }
        }

        return postCollection
    }
}
