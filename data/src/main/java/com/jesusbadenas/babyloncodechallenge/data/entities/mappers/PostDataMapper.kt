package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.PostData
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostDataMapper
@Inject
constructor() {
    fun transform(postData: PostData): PostEntity {
        return PostEntity(postData.userId, postData.id, postData.title, postData.body)
    }

    fun transform(postDataList: List<PostData>): List<PostEntity> {
        val postEntityList = ArrayList<PostEntity>()
        for (postData in postDataList) {
            val postEntity = transform(postData)
            postEntityList.add(postEntity)
        }
        return postEntityList
    }
}
