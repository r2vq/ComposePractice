package com.keanequibilan.database

import com.keanequibilan.database.entity.PokedexItem

interface DatabaseClient {
    suspend fun getPokedexEntries(): List<PokedexItem>

    suspend fun getPokedexEntry(id: Int): PokedexItem

    suspend fun addAllPokedexEntries(vararg items: PokedexItem)
}
