package com.interview.codetest

import android.app.Application
import android.content.Context
import com.interview.codetest.core.di.AppModule
import org.koin.core.context.startKoin

class CodeTestApplication : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        startKoin {
            modules(AppModule)
        }
    }

}