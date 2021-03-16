package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.PokedexPage

@Dao
interface PokedexPageDao {
    @Query("SELECT * FROM PokedexPage WHERE `offset` = :offset AND `limit` = :limit")
    suspend fun getPage(
        offset: Int,
        limit: Int
    ): PokedexPage?

    @Insert
    suspend fun insert(
        item: PokedexPage
    )
}
