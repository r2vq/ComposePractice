package com.keanequibilan.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokedexItem(
    @PrimaryKey val id: Int,
    val name: String
)
