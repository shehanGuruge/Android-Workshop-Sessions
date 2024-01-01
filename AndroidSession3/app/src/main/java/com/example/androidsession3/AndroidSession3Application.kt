package com.example.androidsession3

import android.app.Application
import com.example.androidsession3.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AndroidSession3Application: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AndroidSession3Application)
            modules(appModule)
        }
    }
}