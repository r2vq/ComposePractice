package com.keanequibilan.puppapp

import android.app.Application
import com.facebook.stetho.Stetho
import com.keanequibilan.database.DATABASE_MODULE
import com.keanequibilan.puppapp.di.APP_MODULE
import com.keanequibilan.puppapp.network.NETWORK_MODULE
import com.keanequibilan.puppapp.repository.REPOSITORY_MODULE
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

@Suppress("unused")
class PuppApp : Application() {

    private val appModules = listOf(
        APP_MODULE,
        DATABASE_MODULE,
        NETWORK_MODULE,
        REPOSITORY_MODULE
    )

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        startKoin {
            androidContext(this@PuppApp)
            modules(appModules)
        }
    }
}
