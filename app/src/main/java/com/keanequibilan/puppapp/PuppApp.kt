package com.keanequibilan.puppapp

import android.app.Application
import com.keanequibilan.puppapp.di.APP_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class PuppApp : Application() {

    private val appModules = listOf(
        APP_MODULE
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PuppApp)
            modules(appModules)
        }
    }
}
