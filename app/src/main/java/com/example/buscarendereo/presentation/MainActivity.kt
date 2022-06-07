package com.example.buscarendereo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buscarendereo.databinding.ActivityMainBinding
import com.example.buscarendereo.di.apiModules
import com.example.buscarendereo.di.domainModule
import com.example.buscarendereo.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.error.KoinAppAlreadyStartedException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}