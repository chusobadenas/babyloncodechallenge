package com.jesusbadenas.babyloncodechallenge.common

import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.jesusbadenas.babyloncodechallenge.di.modules.ActivityModule
import com.jesusbadenas.babyloncodechallenge.navigation.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    val activityModule: ActivityModule
        get() = ActivityModule(this)

    fun addFragment(containerViewId: Int, fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(containerViewId, fragment)
            .commit()
    }

    fun replaceFragment(containerViewId: Int, fragment: Fragment, addToBackStack: Boolean) {
        var transaction = supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
        if (addToBackStack) {
            transaction = transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    fun getCurrentFragment(containerId: Int): Fragment? {
        return supportFragmentManager.findFragmentById(containerId)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var result = super.onOptionsItemSelected(item)
        if (android.R.id.home == item.itemId) {
            onBackPressed()
            result = true
        }
        return result
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
