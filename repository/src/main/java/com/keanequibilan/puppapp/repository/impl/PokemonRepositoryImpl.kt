package com.keanequibilan.puppapp.repository.impl

import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.PokedexItem

class PokemonRepositoryImpl(
    val api: PokemonService
) : PokemonRepository {
    override suspend fun getPokedex(
        offset: Int
    ): List<PokedexItem> = api
        .getPokedex(offset)
        .results
        .map { entry -> entry.name to entry.url.asEntryId() }
        .mapNotNull { (name, id) -> id?.let { name to id } }
        .map { (name, id) ->
            PokedexItem(
                id = id,
                name = name
            )
        }
}

private fun String.asEntryId(): Int? = split("/")
    .lastOrNull { it.matches("-?\\d+(\\.\\d+)?".toRegex()) }
    ?.toInt()
