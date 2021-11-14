package com.example.testiaintereactiveapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.testiaintereactiveapp.core.Resource
import com.example.testiaintereactiveapp.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class LoginViewModel(private val repo: LoginRepository): ViewModel() {

    fun getAccessToken() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
           emit(Resource.Success(repo.getAccessToken()))
        } catch (e: Exception) {
           emit(Resource.Failure(e))
        }
    }
}

class LoginViewModelFactory(private val repo: LoginRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(LoginRepository::class.java).newInstance(repo)
    }
}