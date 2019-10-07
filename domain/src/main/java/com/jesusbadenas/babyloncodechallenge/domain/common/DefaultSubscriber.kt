package com.jesusbadenas.babyloncodechallenge.domain.common

import io.reactivex.observers.DisposableObserver

open class DefaultSubscriber<T> : DisposableObserver<T>() {

    override fun onComplete() {
        // no-op by default.
    }

    override fun onError(throwable: Throwable) {
        // no-op by default.
    }

    override fun onNext(t: T) {
        // no-op by default.
    }
}
