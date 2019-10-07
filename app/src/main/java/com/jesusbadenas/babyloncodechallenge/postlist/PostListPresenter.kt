package com.jesusbadenas.babyloncodechallenge.postlist

import com.jesusbadenas.babyloncodechallenge.common.BasePresenter
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import com.jesusbadenas.babyloncodechallenge.domain.common.DefaultSubscriber
import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.entities.PostEntity
import com.jesusbadenas.babyloncodechallenge.entities.Post
import com.jesusbadenas.babyloncodechallenge.entities.mappers.PostEntityMapper
import javax.inject.Inject

@PerActivity
class PostListPresenter
@Inject
constructor(
    private val getPostsUseCase: UseCase<List<PostEntity>>,
    private val postEntityMapper: PostEntityMapper
) : BasePresenter<PostListMvpView>() {

    fun initialize() {
        checkViewAttached()
        loadPostList()
    }

    override fun detachView() {
        super.detachView()
        getPostsUseCase.unsubscribe()
    }

    private fun loadPostList() {
        mvpView?.hideRetry()
        mvpView?.showLoading()
        getPosts()
    }

    fun onPostClicked(post: Post) {
        mvpView?.viewPost(post)
    }

    private fun showPostsInView(postEntities: List<PostEntity>) {
        val posts = postEntityMapper.mapFrom(postEntities)
        mvpView?.showPosts(posts)
    }

    private fun getPosts() {
        getPostsUseCase.execute(PostsSubscriber(), null)
    }

    private inner class PostsSubscriber : DefaultSubscriber<List<PostEntity>>() {

        override fun onError(throwable: Throwable) {
            mvpView?.hideLoading()
            showErrorMessage(throwable, "Error loading posts", null)
            mvpView?.showRetry()
        }

        override fun onNext(posts: List<PostEntity>) {
            mvpView?.hideLoading()
            showPostsInView(posts)
        }
    }
}
