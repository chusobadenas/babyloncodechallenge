package com.jesusbadenas.babyloncodechallenge.postdetails

import com.jesusbadenas.babyloncodechallenge.common.BasePresenter
import com.jesusbadenas.babyloncodechallenge.di.PerActivity
import com.jesusbadenas.babyloncodechallenge.domain.common.DefaultSubscriber
import com.jesusbadenas.babyloncodechallenge.domain.common.UseCase
import com.jesusbadenas.babyloncodechallenge.domain.entities.UserEntity
import com.jesusbadenas.babyloncodechallenge.entities.mappers.UserEntityMapper
import javax.inject.Inject

@PerActivity
class PostDetailsPresenter
@Inject
constructor(
    private val getUserUseCase: UseCase<UserEntity>,
    private val getCommentsUseCase: UseCase<Long>,
    private val userEntityMapper: UserEntityMapper
) : BasePresenter<PostDetailsMvpView>() {

    private var postId: Int = -1
    private var userId: Int = -1

    fun initialize(postId: Int, userId: Int) {
        checkViewAttached()
        this.postId = postId
        this.userId = userId
        loadUser()
    }

    override fun detachView() {
        super.detachView()
        getUserUseCase.unsubscribe()
        getCommentsUseCase.unsubscribe()
    }

    private fun loadUser() {
        mvpView?.hideRetry()
        mvpView?.showLoading()
        getUser()
    }

    private fun loadComments(userEntity: UserEntity) {
        val user = userEntityMapper.mapFrom(userEntity)
        getComments(user.name)
    }

    private fun getUser() {
        val params: Map<String, Int> = hashMapOf("id" to userId)
        getUserUseCase.execute(UserSubscriber(), params)
    }

    private fun getComments(name: String) {
        val params: Map<String, Int> = hashMapOf("id" to postId)
        getCommentsUseCase.execute(CommentsSubscriber(name), params)
    }

    private fun showPostDetails(name: String, nComments: Long) {
        mvpView?.showPostDetails(name, nComments)
    }

    private inner class UserSubscriber : DefaultSubscriber<UserEntity>() {

        override fun onError(throwable: Throwable) {
            mvpView?.hideLoading()
            showErrorMessage(throwable, "Error loading user", null)
            mvpView?.showRetry()
        }

        override fun onNext(user: UserEntity) {
            mvpView?.hideLoading()
            loadComments(user)
        }
    }

    private inner class CommentsSubscriber(private val name: String) : DefaultSubscriber<Long>() {

        override fun onError(throwable: Throwable) {
            mvpView?.hideLoading()
            showErrorMessage(throwable, "Error loading comments", null)
            mvpView?.showRetry()
        }

        override fun onNext(nComments: Long) {
            mvpView?.hideLoading()
            showPostDetails(name, nComments)
        }
    }
}
