package com.jesusbadenas.babyloncodechallenge.di.modules

import android.content.Context
import com.jesusbadenas.babyloncodechallenge.App
import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.api.Network
import com.jesusbadenas.babyloncodechallenge.data.repositories.CommentDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.PostDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.UserDataRepository
import com.jesusbadenas.babyloncodechallenge.di.ApplicationContext
import com.jesusbadenas.babyloncodechallenge.domain.repositories.CommentRepository
import com.jesusbadenas.babyloncodechallenge.domain.repositories.PostRepository
import com.jesusbadenas.babyloncodechallenge.domain.repositories.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @ApplicationContext
    @Provides
    @Singleton
    internal fun provideContext(application: App): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideApiService(): APIService {
        return Network.newAPIService()
    }

    @Provides
    @Singleton
    internal fun provideCommentRepository(commentDataRepository: CommentDataRepository): CommentRepository {
        return commentDataRepository
    }

    @Provides
    @Singleton
    internal fun providePostRepository(postDataRepository: PostDataRepository): PostRepository {
        return postDataRepository
    }

    @Provides
    @Singleton
    internal fun provideUserRepository(userDataRepository: UserDataRepository): UserRepository {
        return userDataRepository
    }
}
