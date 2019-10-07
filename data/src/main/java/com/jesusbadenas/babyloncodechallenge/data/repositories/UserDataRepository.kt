package com.jesusbadenas.babyloncodechallenge.data.repositories

import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.entities.mappers.UserDataMapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.domain.repositories.UserRepository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataRepository
@Inject
constructor(
    private val apiService: APIService,
    private val userDataMapper: UserDataMapper
) : UserRepository {

    override fun user(userId: Int): Single<UserEntity> {
        val defaultUserEntity = UserEntity(-1, "")
        return apiService.getUsers()
            .map { userDataList ->
                userDataMapper.transform(userDataList)
            }
            .flatMap { userEntityList ->
                Observable.fromIterable(userEntityList)
            }
            .filter { userEntity ->
                userEntity.id == userId
            }
            .first(defaultUserEntity)
    }
}
