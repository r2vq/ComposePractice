package com.keanequibilan.puppapp.network

import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val NETWORK_MODULE: Module = module {
    single<Converter.Factory> {
        MoshiConverterFactory.create()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(get())
            .build()
            .create(DogService::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(get())
            .build()
            .create(JikanService::class.java)
    }

    single<PokemonService> {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(get())
            .build()
            .create(PokemonService::class.java)
    }
}
