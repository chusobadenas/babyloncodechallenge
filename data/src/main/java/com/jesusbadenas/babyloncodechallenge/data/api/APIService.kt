package com.jesusbadenas.babyloncodechallenge.data.api

import com.jesusbadenas.babyloncodechallenge.data.entities.CommentData
import com.jesusbadenas.babyloncodechallenge.data.entities.PostData
import com.jesusbadenas.babyloncodechallenge.data.entities.UserData
import io.reactivex.Observable
import retrofit2.http.GET

interface APIService {

    @GET("comments")
    fun getComments(): Observable<List<CommentData>>

    @GET("posts")
    fun getPosts(): Observable<List<PostData>>

    @GET("users")
    fun getUsers(): Observable<List<UserData>>
}
