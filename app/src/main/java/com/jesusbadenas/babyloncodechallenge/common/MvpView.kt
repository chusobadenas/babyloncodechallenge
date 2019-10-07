package com.jesusbadenas.babyloncodechallenge.common

import android.content.Context
import android.content.DialogInterface

interface MvpView {

    /**
     * Show a view with a progress bar indicating a loading process.
     */
    fun showLoading()

    /**
     * Hide a loading view.
     */
    fun hideLoading()

    /**
     * Show a retry view in case of an error when retrieving data.
     */
    fun showRetry()

    /**
     * Hide a retry view shown if there was an error when retrieving data.
     */
    fun hideRetry()

    /**
     * Shows an error message
     *
     * @param message A string representing an error.
     * @param action  the action to perform (optional).
     */
    fun showError(message: String?, action: DialogInterface.OnClickListener?)

    /**
     * Get a [android.content.Context].
     */
    fun context(): Context
}
