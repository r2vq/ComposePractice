package com.keanequibilan.puppapp.repository

import com.keanequibilan.puppapp.repository.impl.PokedexPage

internal interface PokemonRepository {
    suspend fun getPokedex(
        offset: Int = 0,
        limit: Int = 20
    ): PokedexPage
}
