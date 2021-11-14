package com.example.testiaintereactiveapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.testiaintereactiveapp.core.Resource
import com.example.testiaintereactiveapp.repository.LoginRepository
import com.example.testiaintereactiveapp.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MoviesViewModel(private val repo: MoviesRepository): ViewModel() {

    fun getAllMovies() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repo.getMoviesAll()))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}

class MoviesViewModelFactory(private val repo: MoviesRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MoviesRepository::class.java).newInstance(repo)
    }
}