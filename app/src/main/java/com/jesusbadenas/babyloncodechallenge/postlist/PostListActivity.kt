package com.jesusbadenas.babyloncodechallenge.postlist

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import com.jesusbadenas.babyloncodechallenge.R
import com.jesusbadenas.babyloncodechallenge.common.BaseActivity
import com.jesusbadenas.babyloncodechallenge.entities.Post

class PostListActivity : BaseActivity(), PostListFragment.PostListListener {

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        ButterKnife.bind(this)
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, PostListFragment.newInstance())
        }
    }

    override fun onPostClicked(post: Post) {
        navigator.navigateToPostDetails(this, post.id, post.title, post.body, post.userId)
    }
}
