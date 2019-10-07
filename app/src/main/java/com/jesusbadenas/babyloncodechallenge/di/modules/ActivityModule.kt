package com.jesusbadenas.babyloncodechallenge.di.modules

import android.app.Activity
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @PerActivity
    internal fun activity(): Activity {
        return activity
    }
}
