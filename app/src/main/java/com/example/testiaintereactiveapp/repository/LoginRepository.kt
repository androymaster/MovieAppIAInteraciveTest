package com.example.testiaintereactiveapp.repository

import com.example.testiaintereactiveapp.data.model.AccessToken

interface LoginRepository {
    suspend fun getAccessToken(): AccessToken
}