package com.example.buscarendereo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buscarendereo.di.apiModules
import com.example.buscarendereo.di.domainModule
import com.example.buscarendereo.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(listOf(apiModules, domainModule, viewModelModules))
        }

        setContentView(R.layout.activity_main)
    }
}