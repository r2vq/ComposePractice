package com.keanequibilan.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.keanequibilan.database.entity.PokedexItem

@Dao
internal interface PokedexDao {
    @Query("SELECT * FROM PokedexItem")
    suspend fun getAll(): List<PokedexItem>

    @Query("SELECT * FROM PokedexItem WHERE id = :id")
    suspend fun get(id: Int): PokedexItem

    @Query("SELECT * FROM PokedexItem WHERE id > :offset AND id <= :next")
    suspend fun getPage(
        offset: Int,
        next: Int
    ): List<PokedexItem>

    @Insert
    suspend fun insertAll(vararg items: PokedexItem)
}
