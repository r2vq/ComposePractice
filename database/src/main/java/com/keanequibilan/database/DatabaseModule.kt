package com.keanequibilan.database

import androidx.room.Room
import com.keanequibilan.database.impl.DatabaseClientImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DATABASE_MODULE = module {
    single<DatabaseClient> {
        DatabaseClientImpl(
            db = get()
        )
    }

    single {
        Room
            .databaseBuilder(
                androidContext(),
                AppDatabase::class.java,
                "puppapp-db"
            )
            .build()
    }
}
