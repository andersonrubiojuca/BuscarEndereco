package com.example.buscarendereo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.buscarendereo.di.mainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(mainModule)
        }

        setContentView(R.layout.activity_main)
    }
}