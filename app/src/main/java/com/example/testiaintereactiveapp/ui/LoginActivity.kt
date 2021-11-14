package com.example.testiaintereactiveapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ResourceCursorTreeAdapter
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.testiaintereactiveapp.R
import com.example.testiaintereactiveapp.core.Resource
import com.example.testiaintereactiveapp.data.remote.LoginDataSources
import com.example.testiaintereactiveapp.databinding.ActivityMainBinding
import com.example.testiaintereactiveapp.presentation.LoginViewModel
import com.example.testiaintereactiveapp.presentation.LoginViewModelFactory
import com.example.testiaintereactiveapp.repository.LoginRepositoryImpl
import com.example.testiaintereactiveapp.repository.RetrofitClient
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger


class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel> {
        LoginViewModelFactory(
            LoginRepositoryImpl(
                LoginDataSources(RetrofitClient.webservices)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnValidateUser = findViewById<Button>(R.id.btnLogin)
        btnValidateUser.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            actionBar?.hide()

            viewModel.getAccessToken().observe(this, Observer { result ->
                when (result) {
                    is Resource.Loading -> {
                        Log.d("LiveData", "Loading..")
                    }
                    is Resource.Success -> {
                        Log.d("LiveData", "${result.data}")
                    }
                    is Resource.Failure -> {
                        Log.d("Error", "${result.exception}")
                    }
                }
            })
        }
    }

}
