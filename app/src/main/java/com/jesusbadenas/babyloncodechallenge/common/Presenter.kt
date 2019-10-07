package com.jesusbadenas.babyloncodechallenge.common

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V)

    fun detachView()
}
