package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.PostData
import org.junit.Assert.*
import org.junit.Test

class PostDataMapperTest {

    companion object {
        private const val USER_ID = 10
        private const val ID = 1
        private const val TITLE = "Hi"
        private const val BODY = "Hello world"
    }

    private val postDataMapper = PostDataMapper()
    private val postData = PostData(USER_ID, ID, TITLE, BODY)

    @Test
    fun testTransformToPostEntity() {
        val postEntity = postDataMapper.transform(postData)

        assertEquals(postEntity.userId, USER_ID)
        assertEquals(postEntity.id, ID)
        assertEquals(postEntity.title, TITLE)
        assertEquals(postEntity.body, BODY)
    }

    @Test
    fun testTransformToPostEntityCollection() {
        val postDataList = arrayListOf(postData)

        val postEntities = postDataMapper.transform(postDataList)

        assertTrue(postEntities.isNotEmpty())
        assertSame(postEntities.size, 1)

        val postEntity = postEntities[0]
        assertEquals(postEntity.userId, USER_ID)
        assertEquals(postEntity.id, ID)
        assertEquals(postEntity.title, TITLE)
        assertEquals(postEntity.body, BODY)
    }
}
