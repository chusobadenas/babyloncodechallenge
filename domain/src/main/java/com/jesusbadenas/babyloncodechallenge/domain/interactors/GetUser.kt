package com.jesusbadenas.babyloncodechallenge.domain.interactors

import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.UserRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetUser
@Inject
constructor(private val userRepository: UserRepository) : UseCase<UserEntity>() {

    override fun create(data: Map<String, Any>?): Observable<UserEntity> {
        val userId = data?.get("id") as Int
        return userRepository.user(userId).toObservable()
    }
}
