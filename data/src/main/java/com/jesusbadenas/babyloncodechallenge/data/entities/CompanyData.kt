package com.jesusbadenas.babyloncodechallenge.data.entities

import com.google.gson.annotations.SerializedName

data class CompanyData(
    @SerializedName("name") val name: String,
    @SerializedName("catchPhrase") val catchPhrase: String,
    @SerializedName("bs") val bs: String
)
