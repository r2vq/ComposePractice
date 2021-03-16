package com.keanequibilan.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["offset", "limit"])
data class PokedexPage(
    val offset: Int,
    val limit: Int,
    val next: Int?,
    val previous: Int?
)
