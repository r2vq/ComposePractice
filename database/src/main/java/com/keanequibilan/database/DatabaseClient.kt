package com.keanequibilan.database

import com.keanequibilan.database.model.StoredPokedexDetails
import com.keanequibilan.database.model.StoredPokedexPage

interface DatabaseClient {

    suspend fun getStoredPokedexPage(
        offset: Int,
        limit: Int
    ): StoredPokedexPage?

    suspend fun insertStoredPokedexPage(
        page: StoredPokedexPage
    )

    suspend fun getStoredPokedexDetails(
        id: Int
    ): StoredPokedexDetails?

    suspend fun insertPokedexDetails(
        pokemon: StoredPokedexDetails
    )
}
