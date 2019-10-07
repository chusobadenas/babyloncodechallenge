package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.CommentData
import org.junit.Assert.*
import org.junit.Test

class CommentDataMapperTest {

    companion object {
        private const val POST_ID = 10
        private const val ID = 1
        private const val BODY = "Hello world"
    }

    private val commentDataMapper = CommentDataMapper()
    private val commentData = CommentData(POST_ID, ID, "", "", BODY)

    @Test
    fun testTransformToCommentEntity() {
        val commentEntity = commentDataMapper.transform(commentData)

        assertEquals(commentEntity.postId, POST_ID)
        assertEquals(commentEntity.id, ID)
        assertEquals(commentEntity.body, BODY)
    }

    @Test
    fun testTransformToCommentEntityCollection() {
        val commentDataList = arrayListOf(commentData)

        val commentEntities = commentDataMapper.transform(commentDataList)

        assertTrue(commentEntities.isNotEmpty())
        assertSame(commentEntities.size, 1)

        val commentEntity = commentEntities[0]
        assertEquals(commentEntity.postId, POST_ID)
        assertEquals(commentEntity.id, ID)
        assertEquals(commentEntity.body, BODY)
    }
}
