package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.PokedexDetails

@Dao
interface PokedexDetailsDao {
    @Query("SELECT * FROM PokedexDetails WHERE `id` = :id")
    suspend fun getPokemon(id: Int): PokedexDetails?

    @Insert
    suspend fun insertPokemon(pokemon: PokedexDetails)
}
