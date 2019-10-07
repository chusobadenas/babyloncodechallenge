package com.jesusbadenas.babyloncodechallenge.di.modules

import com.jesusbadenas.babyloncodechallenge.common.BaseFragment
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import com.jesusbadenas.babyloncodechallenge.postdetails.PostDetailsFragment
import com.jesusbadenas.babyloncodechallenge.postlist.PostListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingsModule {

    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributeBaseFragmentInjector(): BaseFragment

    @PerActivity
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun contributePostListFragmentInjector(): PostListFragment

    @PerActivity
    @ContributesAndroidInjector(modules = [PostModule::class])
    internal abstract fun contributePostDetailsFragmentInjector(): PostDetailsFragment
}
