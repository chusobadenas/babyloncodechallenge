package com.jesusbadenas.babyloncodechallenge.data.repositories

import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.entities.PostData
import com.jesusbadenas.babyloncodechallenge.data.entities.mappers.PostDataMapper
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.reactivex.Observable
import org.junit.Assert.assertSame
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PostDataRepositoryTest {

    companion object {
        private const val USER_ID = 10
        private const val ID = 1
        private const val TITLE = "Hi"
        private const val BODY = "Hello world"
    }

    private val postData = PostData(USER_ID, ID, TITLE, BODY)
    lateinit var postDataRepository: PostDataRepository

    @MockK
    lateinit var apiService: APIService

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postDataRepository = PostDataRepository(apiService, PostDataMapper())
    }

    @Test
    fun testGetPosts() {
        val postDataList = listOf(postData)
        val observablePostDataList = Observable.just(postDataList)

        every { apiService.getPosts() } returns observablePostDataList

        val observable = postDataRepository.posts()
        val testObserver = observable.test()
        testObserver.assertNoErrors()
        val postEntities = testObserver.values()[0]

        assertTrue(postEntities.isNotEmpty())
        assertSame(postEntities.size, 1)
        assertSame(postEntities[0].userId, USER_ID)
        assertSame(postEntities[0].id, ID)
        assertSame(postEntities[0].title, TITLE)
        assertSame(postEntities[0].body, BODY)
    }
}
