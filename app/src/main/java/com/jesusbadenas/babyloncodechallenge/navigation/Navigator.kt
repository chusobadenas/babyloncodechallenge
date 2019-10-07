package com.jesusbadenas.babyloncodechallenge.navigation

import android.content.Context
import com.jesusbadenas.babyloncodechallenge.postdetails.PostDetailsActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator
@Inject
constructor() {
    fun navigateToPostDetails(
        context: Context?,
        id: Int,
        title: String,
        body: String,
        userId: Int
    ) {
        if (context != null) {
            val intentToLaunch =
                PostDetailsActivity.getCallingIntent(context, id, title, body, userId)
            context.startActivity(intentToLaunch)
        }
    }
}
