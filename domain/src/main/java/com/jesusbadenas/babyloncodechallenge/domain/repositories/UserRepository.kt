package com.jesusbadenas.babyloncodechallenge.domain.repositories

import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import io.reactivex.Single

interface UserRepository {

    fun user(userId: Int): Single<UserEntity>
}
