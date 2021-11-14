package com.example.testiaintereactiveapp.repository

import com.example.testiaintereactiveapp.application.AppConstants
import com.example.testiaintereactiveapp.data.model.*
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface WebServices {

    @POST("v2/oauth/token")
    suspend fun getOauthToken(
      @Header("api_key") apiKey: String,
      @Body body : DataProfileUser
    ) : AccessToken

    @GET("v1/members/profile")
    suspend fun getDataUser(
      @Header("api_key") apiKey: String,
      @Query("country_code") country_code: String,
    ) : DataUser

    @GET("v2/movies")
    suspend fun getDataMovies(
        @Header("api_key") apiKey: String,
        @Query("country_code") country_code: String,
        @Query("cinemas") cinemas: Int
    ) : DataMovies
}

object RetrofitClient {
    val webservices: WebServices by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build().create(WebServices::class.java)
    }
}