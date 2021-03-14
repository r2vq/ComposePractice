package com.keanequibilan.puppapp.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokedexResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokedexEntry>
)

/**
 * Example:
 * {
 *     "name": "bulbasaur",
 *     "url": "https://pokeapi.co/api/v2/pokemon/1/"
 * }
 */
@JsonClass(generateAdapter = true)
data class PokedexEntry(
    val name: String,
    val url: String
)

@JsonClass(generateAdapter = true)
data class PokemonResponse(
    val id: Int,
    val name: String,
    val sprites: SpritesResponse
)

@JsonClass(generateAdapter = true)
data class SpritesResponse(
    @Json(name = "front_default")
    val frontDefault: String,
    @Json(name = "other")
    val other: OtherSpritesResponse
)

@JsonClass(generateAdapter = true)
data class OtherSpritesResponse(
    @Json(name = "official-artwork")
    val officialArtwork: OfficialArtworkResponse
)

@JsonClass(generateAdapter = true)
data class OfficialArtworkResponse(
    @Json(name = "front_default")
    val frontDefault: String
)
