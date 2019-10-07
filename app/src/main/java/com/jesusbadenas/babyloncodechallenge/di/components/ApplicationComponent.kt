package com.jesusbadenas.babyloncodechallenge.di.components

import android.content.Context
import com.jesusbadenas.babyloncodechallenge.App
import com.jesusbadenas.babyloncodechallenge.data.api.APIService
import com.jesusbadenas.babyloncodechallenge.data.repositories.CommentDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.PostDataRepository
import com.jesusbadenas.babyloncodechallenge.data.repositories.UserDataRepository
import com.jesusbadenas.babyloncodechallenge.di.ApplicationContext
import com.jesusbadenas.babyloncodechallenge.di.modules.ActivityBindingsModule
import com.jesusbadenas.babyloncodechallenge.di.modules.ApplicationModule
import com.jesusbadenas.babyloncodechallenge.di.modules.FragmentBindingsModule
import com.jesusbadenas.babyloncodechallenge.navigation.Navigator
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, ActivityBindingsModule::class,
        FragmentBindingsModule::class, ApplicationModule::class]
)
interface ApplicationComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {

        fun build(): ApplicationComponent

        @BindsInstance
        fun application(application: App): Builder
    }

    @ApplicationContext
    fun context(): Context

    fun apiService(): APIService

    fun navigator(): Navigator

    fun commentDataRepository(): CommentDataRepository

    fun postDataRepository(): PostDataRepository

    fun userDataRepository(): UserDataRepository
}
