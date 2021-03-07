package com.keanequibilan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.database.dao.PokedexDao
import com.keanequibilan.database.entity.PokedexItem

@Database(entities = [PokedexItem::class], version = 1)
internal abstract class AppDatabase: RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao
}
