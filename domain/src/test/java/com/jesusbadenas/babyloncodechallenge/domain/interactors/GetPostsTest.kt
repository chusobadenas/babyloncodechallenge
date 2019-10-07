package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.PostRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test

class GetPostsTest {

    lateinit var getPosts: GetPosts

    @MockK
    lateinit var postRepository: PostRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getPosts = GetPosts(postRepository)
    }

    @Test
    fun testGetPosts() {
        val observable = Observable.empty<List<PostEntity>>()
        every { postRepository.posts() } returns observable

        getPosts.create(null)

        verify { postRepository.posts() }
    }
}
