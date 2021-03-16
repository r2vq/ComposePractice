package com.keanequibilan.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.keanequibilan.database.dao.PokedexDao
import com.keanequibilan.database.dao.PokedexDetailsDao
import com.keanequibilan.database.dao.PokedexPageDao
import com.keanequibilan.database.entity.PokedexDetails
import com.keanequibilan.database.entity.PokedexItem
import com.keanequibilan.database.entity.PokedexPage

@Database(
    entities = [
        PokedexItem::class,
        PokedexPage::class,
        PokedexDetails::class
    ],
    version = 1
)
internal abstract class AppDatabase : RoomDatabase() {
    abstract fun pokedexDao(): PokedexDao
    abstract fun pokedexPageDao(): PokedexPageDao
    abstract fun pokedexDetailsDao(): PokedexDetailsDao
}
