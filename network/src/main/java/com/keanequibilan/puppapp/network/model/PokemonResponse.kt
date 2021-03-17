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
    val sprites: SpritesResponse,
    val types: List<TypeResponse>
)

@JsonClass(generateAdapter = true)
data class SpritesResponse(
    @Json(name = "front_default")
    val frontDefault: String?,
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
    val frontDefault: String?
)

@JsonClass(generateAdapter = true)
data class TypeResponse(
    @Json(name = "slot")
    val slot: Int,
    @Json(name = "type")
    val type: TypeChildResponse
)

@JsonClass(generateAdapter = true)
data class TypeChildResponse(
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)
