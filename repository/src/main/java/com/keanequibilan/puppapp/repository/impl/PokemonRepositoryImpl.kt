package com.keanequibilan.puppapp.repository.impl

import androidx.core.net.toUri
import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.LocalPokemon
import com.keanequibilan.puppapp.repository.model.PokedexItem

internal class PokemonRepositoryImpl(
    val api: PokemonService
) : PokemonRepository {
    override suspend fun getPokedex(
        offset: Int,
        limit: Int
    ): PokedexPage = api
        .getPokedex(offset, limit)
        .run {
            PokedexPage(
                next = next?.getOffset(),
                previous = previous?.getOffset(),
                items = results
                    .mapNotNull { entry ->
                        entry
                            .url
                            .getId()
                            ?.let { id -> entry.name to id }
                    }
                    .map { (name, id) ->
                        PokedexItem(
                            id = id,
                            name = name
                        )
                    }
            )
        }

    override suspend fun getPokemon(
        id: Int
    ): LocalPokemon = api
        .getPokemon(id)
        .run {
            LocalPokemon(
                id = id,
                name = name,
                spriteFront = sprites.front_default.toUri()
            )
        }
}

data class PokedexPage(
    val next: Int?,
    val previous: Int?,
    val items: List<PokedexItem>
)

private fun String?.getId(): Int? = this
    ?.toUri()
    ?.lastPathSegment
    ?.toInt()

private fun String.getOffset(): Int? = toUri()
    .getQueryParameter("offset")
    ?.toInt()
