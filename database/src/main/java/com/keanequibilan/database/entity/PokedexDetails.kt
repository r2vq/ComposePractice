package com.keanequibilan.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PokedexDetails(
    @PrimaryKey val id: Int,
    val name: String,
    val spriteFront: String,
    val officialArtwork: String?,
    val types: String
)
