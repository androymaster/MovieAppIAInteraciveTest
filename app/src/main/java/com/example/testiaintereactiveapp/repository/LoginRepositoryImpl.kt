package com.example.testiaintereactiveapp.repository

import com.example.testiaintereactiveapp.data.model.AccessToken
import com.example.testiaintereactiveapp.data.remote.LoginDataSources

class LoginRepositoryImpl(private val dataSources: LoginDataSources): LoginRepository {

    override suspend fun getAccessToken(): AccessToken = dataSources.getAccessToken()
}