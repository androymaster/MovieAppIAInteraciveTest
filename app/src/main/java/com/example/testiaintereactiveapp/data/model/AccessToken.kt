package com.example.testiaintereactiveapp.data.model

import com.google.gson.annotations.SerializedName

data class AccessToken(
    @SerializedName(".expires")
    val expires: String,
    @SerializedName(".issued")
    val issued: String,
    @SerializedName("access_token")
    val access_token: String,
    @SerializedName("as:client_id")
    val client_id: String,
    @SerializedName("country_code")
    val country_code: String,
    @SerializedName("expires_in")
    val expires_in: Int,
    @SerializedName("refresh_token")
    val refresh_token: String,
    @SerializedName("token_type")
    val token_type: String,
    @SerializedName("username")
    val username: String
)