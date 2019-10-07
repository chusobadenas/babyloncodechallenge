package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.repositories.CommentRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetCommentsTest {

    companion object {
        private const val POST_ID = 1
    }

    lateinit var getComments: GetComments

    @MockK
    lateinit var commentRepository: CommentRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getComments = GetComments(commentRepository)
    }

    @Test
    fun testGetComments() {
        val observable = Single.fromObservable(Observable.empty<Long>())
        every { commentRepository.numberOfComments(POST_ID) } returns observable

        val params = hashMapOf("id" to POST_ID)
        getComments.create(params)

        verify { commentRepository.numberOfComments(POST_ID) }
    }
}
