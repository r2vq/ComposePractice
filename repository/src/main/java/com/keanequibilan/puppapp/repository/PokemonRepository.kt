package com.keanequibilan.puppapp.repository

import com.keanequibilan.puppapp.repository.model.PokedexItem

interface PokemonRepository {
    suspend fun getPokedex(
        offset: Int = 0
    ): List<PokedexItem>
}
