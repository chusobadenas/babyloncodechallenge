package com.jesusbadenas.babyloncodechallenge.postlist

import com.jesusbadenas.babyloncodechallenge.common.MvpView
import com.jesusbadenas.babyloncodechallenge.entities.Post

interface PostListMvpView : MvpView {

    fun showPosts(posts: List<Post>)

    fun viewPost(post: Post)
}
