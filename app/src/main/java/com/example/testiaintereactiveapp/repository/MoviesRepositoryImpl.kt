package com.example.testiaintereactiveapp.repository

import com.example.testiaintereactiveapp.data.model.DataMovies
import com.example.testiaintereactiveapp.data.remote.MoviesDataSources

class MoviesRepositoryImpl(private val dataSources: MoviesDataSources): MoviesRepository {

    override suspend fun getMoviesAll(): DataMovies = dataSources.getAllMovies()

}