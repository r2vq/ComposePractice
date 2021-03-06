package com.keanequibilan.puppapp.repository

import com.keanequibilan.puppapp.repository.impl.PokemonRepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single<PokemonRepository> {
        PokemonRepositoryImpl(
            api = get()
        )
    }
}
