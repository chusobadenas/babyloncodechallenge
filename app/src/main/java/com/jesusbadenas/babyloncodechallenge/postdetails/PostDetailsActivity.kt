package com.jesusbadenas.babyloncodechallenge.postdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.common.BaseActivity

class PostDetailsActivity : BaseActivity() {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    var postId: Int = -1
    var postTitle: String? = null
    var postBody: String? = null
    var userId: Int = -1

    companion object {
        private const val INTENT_PARAM_POST_ID = "INTENT_PARAM_POST_ID"
        private const val INTENT_PARAM_POST_TITLE = "INTENT_PARAM_POST_TITLE"
        private const val INTENT_PARAM_POST_BODY = "INTENT_PARAM_POST_BODY"
        private const val INTENT_PARAM_USER_ID = "INTENT_PARAM_USER_ID"

        fun getCallingIntent(context: Context, id: Int, title: String, body: String, userId: Int)
                : Intent {
            val callingIntent = Intent(context, PostDetailsActivity::class.java)
            callingIntent.putExtra(INTENT_PARAM_POST_ID, id)
            callingIntent.putExtra(INTENT_PARAM_POST_TITLE, title)
            callingIntent.putExtra(INTENT_PARAM_POST_BODY, body)
            callingIntent.putExtra(INTENT_PARAM_USER_ID, userId)
            return callingIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        initializeActivity()
        ButterKnife.bind(this)
        setupToolbar()
    }

    private fun initializeActivity() {
        postId = intent.getIntExtra(INTENT_PARAM_POST_ID, -1)
        postTitle = intent.getStringExtra(INTENT_PARAM_POST_TITLE)
        postBody = intent.getStringExtra(INTENT_PARAM_POST_BODY)
        userId = intent.getIntExtra(INTENT_PARAM_USER_ID, -1)
        addFragment(R.id.fragmentContainer, PostDetailsFragment.newInstance())
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
