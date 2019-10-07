package com.jesusbadenas.babyloncodechallenge.di

import android.content.Context
import com.jesusbadenas.babyloncodechallenge.App
import com.jesusbadenas.babyloncodechallenge.data.repositories.CommentDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.PostDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.UserDataRepository
import com.jesusbadenas.babyloncodechallenge.di.modules.ApplicationModule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class ApplicationModuleTest {

    lateinit var applicationModule: ApplicationModule

    @MockK
    lateinit var application: App
    @MockK
    lateinit var context: Context
    @MockK
    lateinit var commentDataRepository: CommentDataRepository
    @MockK
    lateinit var postDataRepository: PostDataRepository
    @MockK
    lateinit var userDataRepository: UserDataRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        applicationModule = ApplicationModule()
        every { application.applicationContext } returns context
    }

    @Test
    fun testProvideApplicationContextSuccess() {
        val ctx = applicationModule.provideContext(application)
        assertNotNull(ctx)
        assertEquals(ctx, context)
    }

    @Test
    fun testProvideAPIServiceSuccess() {
        val apiService = applicationModule.provideApiService()
        assertNotNull(apiService)
    }

    @Test
    fun testProvideCommentRepositorySuccess() {
        assertEquals(
            applicationModule.provideCommentRepository(commentDataRepository),
            commentDataRepository
        )
    }

    @Test
    fun testProvidePostRepositorySuccess() {
        assertEquals(
            applicationModule.providePostRepository(postDataRepository),
            postDataRepository
        )
    }

    @Test
    fun testProvideUserRepositorySuccess() {
        assertEquals(
            applicationModule.provideUserRepository(userDataRepository),
            userDataRepository
        )
    }
}
