package com.example.testiaintereactiveapp.data.remote

import com.example.testiaintereactiveapp.application.AppConstants
import com.example.testiaintereactiveapp.data.model.DataMovies
import com.example.testiaintereactiveapp.repository.WebServices

class MoviesDataSources(private val webServices: WebServices) {

    suspend fun getAllMovies(): DataMovies {
        return webServices.getDataMovies(
            AppConstants.API_KEY,
            AppConstants.COUNTRY_CODE,
            AppConstants.INCLUDE_CINEMAS
        )
    }
}