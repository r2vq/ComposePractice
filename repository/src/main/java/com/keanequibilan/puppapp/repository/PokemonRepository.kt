package com.keanequibilan.puppapp.repository

import com.keanequibilan.puppapp.repository.impl.PokedexPage
import com.keanequibilan.puppapp.repository.model.LocalPokemon

interface PokemonRepository {
    suspend fun getPokedex(
        offset: Int = 0,
        limit: Int = 20
    ): PokedexPage

    suspend fun getPokemon(
        id: Int
    ): LocalPokemon
}
