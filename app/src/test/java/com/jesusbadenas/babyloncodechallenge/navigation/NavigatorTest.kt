package com.jesusbadenas.babyloncodechallenge.navigation

import android.content.ActivityNotFoundException
import android.content.Context
import com.jesusbadenas.babyloncodechallenge.App
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = App::class, sdk = [27])
class NavigatorTest {

    private val navigator = Navigator()

    @MockK(relaxed = true)
    lateinit var context: Context

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    @Test
    fun testNavigateToPostDetailsSuccess() {
        try {
            navigator.navigateToPostDetails(context, 1, "", "", 10)
        } catch (exception: ActivityNotFoundException) {
            fail("PostDetailsActivity not found")
        }
    }
}
