package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.UserRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class GetUserTest {

    companion object {
        private const val USER_ID = 1
    }

    lateinit var getUser: GetUser

    @MockK
    lateinit var userRepository: UserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getUser = GetUser(userRepository)
    }

    @Test
    fun testGetUser() {
        val observable = Single.fromObservable(Observable.empty<UserEntity>())
        every { userRepository.user(USER_ID) } returns observable

        val params = hashMapOf("id" to USER_ID)
        getUser.create(params)

        verify { userRepository.user(USER_ID) }
    }
}
