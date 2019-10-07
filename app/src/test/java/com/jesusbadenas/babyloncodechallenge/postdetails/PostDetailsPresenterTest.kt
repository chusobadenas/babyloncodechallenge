package com.jesusbadenas.babyloncodechallenge.postdetails

import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetComments
import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetUser
import com.jesusbadenas.babyloncodechallenge.entities.mappers.UserEntityMapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class PostDetailsPresenterTest {

    private lateinit var postDetailsPresenter: PostDetailsPresenter

    @MockK(relaxed = true)
    lateinit var getUserUseCase: GetUser
    @MockK(relaxed = true)
    lateinit var getCommentsUseCase: GetComments
    @MockK(relaxed = true)
    lateinit var postDetailsMvpView: PostDetailsMvpView

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postDetailsPresenter =
            PostDetailsPresenter(getUserUseCase, getCommentsUseCase, UserEntityMapper())
        postDetailsPresenter.attachView(postDetailsMvpView)
    }

    @Test
    fun testAttachViewSuccess() {
        assertNotNull(postDetailsPresenter.mvpView)
    }

    @Test
    fun testDetachViewSuccess() {
        postDetailsPresenter.detachView()
        assertNull(postDetailsPresenter.mvpView)
        verify { getUserUseCase.unsubscribe() }
        verify { getCommentsUseCase.unsubscribe() }
    }

    @Test
    fun testInitializeSuccess() {
        postDetailsPresenter.initialize(1, 10)
        verify { postDetailsMvpView.hideRetry() }
        verify { postDetailsMvpView.showLoading() }
        verify { getUserUseCase.execute(any(), eq(hashMapOf("id" to 10))) }
    }
}
