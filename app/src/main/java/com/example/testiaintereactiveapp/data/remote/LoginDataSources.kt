package com.example.testiaintereactiveapp.data.remote

import com.example.testiaintereactiveapp.application.AppConstants
import com.example.testiaintereactiveapp.data.model.AccessToken
import com.example.testiaintereactiveapp.repository.WebServices

class LoginDataSources(private val webServices: WebServices) {

    suspend fun getAccessToken(): AccessToken{
        return webServices.getOauthToken(AppConstants.API_KEY, AppConstants.BODY)
    }

}