package com.example.testiaintereactiveapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.testiaintereactiveapp.R
import com.example.testiaintereactiveapp.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnValidateUser = findViewById<Button>(R.id.btnLogin)
        btnValidateUser.setOnClickListener {
             val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        actionBar?.hide()

        }
    }
}
