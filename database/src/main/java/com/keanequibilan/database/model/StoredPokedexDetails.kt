package com.keanequibilan.database.model

data class StoredPokedexDetails(
    val id: Int,
    val name: String,
    val spriteFront: String,
    val officialArtwork: String,
    val types: List<String>
)
