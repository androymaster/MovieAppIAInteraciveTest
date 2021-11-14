package com.example.testiaintereactiveapp.ui.movies

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testiaintereactiveapp.R
import com.example.testiaintereactiveapp.core.Resource
import com.example.testiaintereactiveapp.data.remote.LoginDataSources
import com.example.testiaintereactiveapp.data.remote.MoviesDataSources
import com.example.testiaintereactiveapp.databinding.FragmentMovieBillboardBinding
import com.example.testiaintereactiveapp.presentation.LoginViewModel
import com.example.testiaintereactiveapp.presentation.LoginViewModelFactory
import com.example.testiaintereactiveapp.presentation.MoviesViewModel
import com.example.testiaintereactiveapp.presentation.MoviesViewModelFactory
import com.example.testiaintereactiveapp.repository.LoginRepositoryImpl
import com.example.testiaintereactiveapp.repository.MoviesRepositoryImpl
import com.example.testiaintereactiveapp.repository.RetrofitClient

class MovieBillboardFragment : Fragment(R.layout.fragment_movie_billboard) {

    private var _binding: FragmentMovieBillboardBinding? = null
    private val viewModel by viewModels<MoviesViewModel> {
        MoviesViewModelFactory(
            MoviesRepositoryImpl(
                MoviesDataSources(RetrofitClient.webservices)
            )
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMovieBillboardBinding.bind(view)

        viewModel.getAllMovies().observe(viewLifecycleOwner, Observer { results ->
            when (results) {
                is Resource.Loading -> {
                    Log.d("LiveData", "Loading..")
                }
                is Resource.Success -> {
                    Log.d("LiveData", "${results.data}")
                }
                is Resource.Failure -> {
                    Log.d("Error", "${results.exception}")
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}