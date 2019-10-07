package com.jesusbadenas.babyloncodechallenge.common

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.di.modules.GlideApp

object UIUtils {

    fun loadImageUrl(context: Context, view: ImageView, url: String?) {
        GlideApp.with(context)
            .load(url)
            .centerCrop()
            .placeholder(R.color.bg_light_grey)
            .error(R.color.bg_light_grey)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(view)
    }
}
