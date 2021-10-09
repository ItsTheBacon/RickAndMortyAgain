package com.example.rickandmortyagain

import android.app.Application
import com.example.rickandmortyagain.servicelocator.rickMortyModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(rickMortyModules)
        }
    }
}