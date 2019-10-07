package com.jesusbadenas.babyloncodechallenge.postlist

import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetPosts
import com.jesusbadenas.babyloncodechallenge.entities.Post
import com.jesusbadenas.babyloncodechallenge.entities.mappers.PostEntityMapper
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

class PostListPresenterTest {

    private lateinit var postListPresenter: PostListPresenter

    @MockK(relaxed = true)
    lateinit var getPosts: GetPosts
    @MockK(relaxed = true)
    lateinit var postListMvpView: PostListMvpView

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        postListPresenter = PostListPresenter(getPosts, PostEntityMapper())
        postListPresenter.attachView(postListMvpView)
    }

    @Test
    fun testAttachViewSuccess() {
        assertNotNull(postListPresenter.mvpView)
    }

    @Test
    fun testDetachViewSuccess() {
        postListPresenter.detachView()
        assertNull(postListPresenter.mvpView)
        verify { getPosts.unsubscribe() }
    }

    @Test
    fun testInitializeSuccess() {
        postListPresenter.initialize()
        verify { postListMvpView.hideRetry() }
        verify { postListMvpView.showLoading() }
        verify { getPosts.execute(any(), null) }
    }

    @Test
    fun testOnPostClickedSuccess() {
        val post = Post(10, 1, "", "")
        postListPresenter.onPostClicked(post)
        verify { postListMvpView.viewPost(post) }
    }
}
