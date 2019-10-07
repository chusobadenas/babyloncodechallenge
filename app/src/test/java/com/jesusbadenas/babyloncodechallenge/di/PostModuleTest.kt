package com.jesusbadenas.babyloncodechallenge.di

import com.jesusbadenas.babyloncodechallenge.data.repositories.CommentDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.PostDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.UserDataRepository
import com.jesusbadenas.babyloncodechallenge.di.modules.PostModule
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class PostModuleTest {

    private lateinit var postModule: PostModule

    @MockK
    lateinit var commentDataRepository: CommentDataRepository
    @MockK
    lateinit var postDataRepository: PostDataRepository
    @MockK
    lateinit var userDataRepository: UserDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postModule = PostModule()
    }

    @Test
    fun testProvideGetCommentsUseCase() {
        assertNotNull(postModule.provideGetCommentsUseCase(commentDataRepository))
    }

    @Test
    fun testProvideGetPostsUseCase() {
        assertNotNull(postModule.provideGetPostsUseCase(postDataRepository))
    }

    @Test
    fun testProvideGetUserUseCase() {
        assertNotNull(postModule.provideGetUserUseCase(userDataRepository))
    }
}
