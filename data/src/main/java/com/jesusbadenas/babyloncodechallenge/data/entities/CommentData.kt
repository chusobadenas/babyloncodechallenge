package com.jesusbadenas.babyloncodechallenge.data.entities

import com.google.gson.annotations.SerializedName

data class CommentData(
    @SerializedName("postId") val postId: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("body") val body: String
)
