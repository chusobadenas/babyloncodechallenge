package com.jesusbadenas.babyloncodechallenge.di.modules

import com.jesusbadenas.babyloncodechallenge.data.repositories.CommentDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.PostDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.UserDataRepository
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetComments
import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetPosts
import com.jesusbadenas.babyloncodechallenge.domain.interactors.GetUser
import dagger.Module
import dagger.Provides

@Module
class PostModule {

    @Provides
    @PerActivity
    internal fun provideGetCommentsUseCase(commentDataRepository: CommentDataRepository)
            : UseCase<Long> {
        return GetComments(commentDataRepository)
    }

    @Provides
    @PerActivity
    internal fun provideGetPostsUseCase(postDataRepository: PostDataRepository)
            : UseCase<List<PostEntity>> {
        return GetPosts(postDataRepository)
    }

    @Provides
    @PerActivity
    internal fun provideGetUserUseCase(userDataRepository: UserDataRepository)
            : UseCase<UserEntity> {
        return GetUser(userDataRepository)
    }
}
