package com.keanequibilan.puppapp.repository.impl

import androidx.core.net.toUri
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.database.model.StoredPokedexDetails
import com.keanequibilan.database.model.StoredPokedexItem
import com.keanequibilan.database.model.StoredPokedexPage
import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.LocalPokemon
import com.keanequibilan.puppapp.repository.model.LocalType
import com.keanequibilan.puppapp.repository.model.PokedexItem

internal class PokemonRepositoryImpl(
    private val api: PokemonService,
    private val db: DatabaseClient
) : PokemonRepository {

    override suspend fun getPokedex(
        offset: Int,
        limit: Int
    ): PokedexPage = getStoredPokedexPage(offset, limit)
        .let { localPage ->
            PokedexPage(
                next = localPage.next,
                previous = localPage.previous,
                items = localPage.items.map { item ->
                    PokedexItem(
                        id = item.id,
                        name = item.name
                    )
                }
            )
        }

    override suspend fun getPokemon(
        id: Int
    ): LocalPokemon = getStoredPokedexDetails(id)
        .let { storedPokemon ->
            LocalPokemon(
                id = id,
                name = storedPokemon.name,
                spriteFront = storedPokemon.spriteFront.toUri(),
                officialArtwork = storedPokemon.officialArtwork.toUri(),
                types = storedPokemon.types.map { name -> LocalType(name) }
            )
        }

    private suspend fun getStoredPokedexPage(
        offset: Int,
        limit: Int
    ) = db.getStoredPokedexPage(offset, limit)
        ?: api
            .getPokedex(offset, limit)
            .run {
                StoredPokedexPage(
                    offset = offset,
                    limit = limit,
                    next = next?.getOffset(),
                    previous = previous?.getOffset(),
                    items = results
                        .mapNotNull { entry ->
                            entry.url.getId()
                                ?.let { id ->
                                    StoredPokedexItem(
                                        id = id,
                                        name = entry.name
                                    )
                                }
                        }
                )
            }
            .also { page -> db.insertStoredPokedexPage(page) }

    private suspend fun getStoredPokedexDetails(
        id: Int
    ) = db.getStoredPokedexDetails(id)
        ?: api
            .getPokemon(id)
            .run {
                StoredPokedexDetails(
                    id = id,
                    name = name,
                    spriteFront = sprites.frontDefault,
                    officialArtwork = sprites.other.officialArtwork.frontDefault,
                    types = types.map { it.type.name }
                )
            }
            .also { pokemon -> db.insertPokedexDetails(pokemon) }
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
