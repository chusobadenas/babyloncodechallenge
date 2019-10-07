package com.jesusbadenas.babyloncodechallenge

import com.jesusbadenas.babyloncodechallenge.di.components.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }
}
