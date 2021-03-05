package com.keanequibilan.puppapp.network.model

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
data class PokedexEntry(
    val name: String,
    val url: String
)

data class PokemonResponse(
    val id: Int,
    val name: String
)
