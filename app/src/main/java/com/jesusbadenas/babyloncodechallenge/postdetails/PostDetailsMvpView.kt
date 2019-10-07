package com.jesusbadenas.babyloncodechallenge.postdetails

import com.jesusbadenas.babyloncodechallenge.common.MvpView

interface PostDetailsMvpView : MvpView {

    fun showPostDetails(name: String, nComments: Long)
}
