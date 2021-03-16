package com.keanequibilan.puppapp.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.repository.impl.PokedexSourceImpl
import com.keanequibilan.puppapp.repository.impl.PokemonRepositoryImpl
import org.koin.dsl.module

val REPOSITORY_MODULE = module {
    single<PokemonRepository> {
        val api = get<PokemonService>()
        val db = get<DatabaseClient>()
        PokemonRepositoryImpl(
            api = api,
            db = db
        )
    }

    single<PokedexSource> {
        PokedexSourceImpl(
            pokemonRepository = get()
        )
    }

    single {
        Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            initialKey = 0,
        ) { get<PokedexSource>() }
    }
}
