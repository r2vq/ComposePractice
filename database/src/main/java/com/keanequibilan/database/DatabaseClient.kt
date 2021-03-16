package com.keanequibilan.database

import com.keanequibilan.database.model.StoredPokedexPage

interface DatabaseClient {

    suspend fun getStoredPokedexPage(
        offset: Int,
        limit: Int
    ): StoredPokedexPage?

    suspend fun insertStoredPokedexPage(
        page: StoredPokedexPage
    )
}
