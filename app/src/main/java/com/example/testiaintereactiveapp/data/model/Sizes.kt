package com.example.testiaintereactiveapp.data.model

import com.google.gson.annotations.SerializedName

data class Sizes(
    val large: String,
    val medium: String,
    val small: String,
    @SerializedName("x-large")
    val largeLong: String
)