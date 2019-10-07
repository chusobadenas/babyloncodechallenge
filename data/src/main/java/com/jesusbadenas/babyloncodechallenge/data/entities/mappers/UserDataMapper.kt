package com.jesusbadenas.babyloncodechallenge.data.entities.mappers

import com.jesusbadenas.babyloncodechallenge.data.entities.UserData
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserDataMapper
@Inject
constructor() {
    fun transform(userData: UserData): UserEntity {
        return UserEntity(userData.id, userData.name)
    }

    fun transform(userDataList: List<UserData>): List<UserEntity> {
        val userEntityList = ArrayList<UserEntity>()
        for (userData in userDataList) {
            val userEntity = transform(userData)
            userEntityList.add(userEntity)
        }
        return userEntityList
    }
}
