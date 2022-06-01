package com.example.buscarendereo

import android.app.Application
import com.example.buscarendereo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationActivity: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationActivity)
            modules(listOf(apiModules, domainModule, viewModelModules))
        }
    }
}