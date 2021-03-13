package com.keanequibilan.puppapp.repository.impl

import androidx.core.net.toUri
import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.PokedexItem

class PokemonRepositoryImpl(
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
