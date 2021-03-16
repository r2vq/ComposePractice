package com.keanequibilan.database.model

data class StoredPokedexPage(
    val offset: Int,
    val limit: Int,
    val previous: Int?,
    val next: Int?,
    val items: List<StoredPokedexItem>
)

data class StoredPokedexItem(
    val id: Int,
    val name: String
)
