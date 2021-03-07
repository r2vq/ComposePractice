package com.keanequibilan.database.impl

import com.keanequibilan.database.AppDatabase
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.database.entity.PokedexItem

internal class DatabaseClientImpl(
    private val db: AppDatabase
) : DatabaseClient {

    override suspend fun getPokedexEntries() = db
        .pokedexDao()
        .getAll()

    override suspend fun getPokedexEntry(id: Int) = db
        .pokedexDao()
        .get(id)

    override suspend fun addAllPokedexEntries(vararg items: PokedexItem) = db
        .pokedexDao()
        .insertAll(*items)
}
