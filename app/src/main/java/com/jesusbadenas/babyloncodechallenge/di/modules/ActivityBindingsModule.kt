package com.jesusbadenas.babyloncodechallenge.di.modules

import com.jesusbadenas.babyloncodechallenge.common.BaseActivity
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import com.jesusbadenas.babyloncodechallenge.postdetails.PostDetailsActivity
import com.jesusbadenas.babyloncodechallenge.postlist.PostListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingsModule {

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributeBaseActivityInjector(): BaseActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun contributePostListActivityInjector(): PostListActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun contributePostDetailsActivityInjector(): PostDetailsActivity
}
