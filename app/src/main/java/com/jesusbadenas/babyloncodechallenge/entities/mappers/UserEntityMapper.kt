package com.jesusbadenas.babyloncodechallenge.entities.mappers

import com.jesusbadenas.babyloncodechallenge.domain.common.Mapper
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.entities.User
import javax.inject.Inject

class UserEntityMapper
@Inject
constructor() : Mapper<UserEntity, User>() {

    override fun mapFrom(from: UserEntity): User = User(
        from.id,
        from.name
    )

    override fun mapFrom(from: List<UserEntity>): List<User> {
        val userCollection: ArrayList<User> = ArrayList()

        if (from.isNotEmpty()) {
            for (userEntity in from) {
                userCollection.add(mapFrom(userEntity))
            }
        }

        return userCollection
    }
}
