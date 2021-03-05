package com.keanequibilan.puppapp.app.usecase

import com.keanequibilan.puppapp.app.model.PokedexItem
import com.keanequibilan.puppapp.network.PokemonService

class PokemonListUseCase(
    private val api: PokemonService
) {
    suspend fun getList(
        offset: Int = 0
    ): List<PokedexItem> = api
        .getPokedex(offset = offset)
        .results
        .map { entry -> entry.name to entry.url.asEntryId() }
        .mapNotNull { (name, id) -> id?.let { name to id } }
        .map { (name, id) ->
            PokedexItem(
                id = id,
                name = name
            )
        }

    private fun String.asEntryId(): Int? = split("/")
        .lastOrNull { it.matches("-?\\d+(\\.\\d+)?".toRegex()) }
        ?.toInt()
}
