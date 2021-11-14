package com.example.testiaintereactiveapp.repository

import com.example.testiaintereactiveapp.data.model.DataMovies

interface MoviesRepository {
    suspend fun getMoviesAll(): DataMovies
}