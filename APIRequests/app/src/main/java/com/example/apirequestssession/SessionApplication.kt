package com.example.apirequestssession

import android.app.Application
import com.example.apirequestssession.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SessionApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SessionApplication);
            modules(appModule);
        }
    }
}