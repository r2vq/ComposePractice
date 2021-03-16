package com.keanequibilan.database.impl

import com.keanequibilan.database.AppDatabase
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.database.entity.PokedexDetails
import com.keanequibilan.database.entity.PokedexItem
import com.keanequibilan.database.entity.PokedexPage
import com.keanequibilan.database.model.StoredPokedexDetails
import com.keanequibilan.database.model.StoredPokedexItem
import com.keanequibilan.database.model.StoredPokedexPage

private const val SEPARATOR = ":::"

internal class DatabaseClientImpl(
    private val db: AppDatabase
) : DatabaseClient {

    override suspend fun getStoredPokedexPage(
        offset: Int,
        limit: Int
    ): StoredPokedexPage? = db.pokedexPageDao()
        .getPage(offset, limit)
        ?.let { page ->
            db.pokedexDao()
                .getPage(offset, limit)
                .run {
                    StoredPokedexPage(
                        offset = page.offset,
                        limit = page.limit,
                        previous = page.previous,
                        next = page.next,
                        items = map { item ->
                            StoredPokedexItem(
                                id = item.id,
                                name = item.name
                            )
                        }
                    )
                }
        }

    override suspend fun getStoredPokedexDetails(
        id: Int
    ): StoredPokedexDetails? = db.pokedexDetailsDao()
        .getPokemon(id)
        ?.let { pokemon ->
            StoredPokedexDetails(
                id = pokemon.id,
                spriteFront = pokemon.spriteFront,
                name = pokemon.name,
                officialArtwork = pokemon.officialArtwork,
                types = pokemon.types.split(SEPARATOR)
            )
        }

    override suspend fun insertPokedexDetails(
        pokemon: StoredPokedexDetails
    ) = db.pokedexDetailsDao()
        .insertPokemon(
            PokedexDetails(
                id = pokemon.id,
                name = pokemon.name,
                spriteFront = pokemon.spriteFront,
                officialArtwork = pokemon.officialArtwork,
                types = pokemon.types.joinToString(SEPARATOR)
            )
        )

    override suspend fun insertStoredPokedexPage(
        page: StoredPokedexPage
    ) {
        db
            .pokedexPageDao()
            .insert(
                PokedexPage(
                    offset = page.offset,
                    limit = page.limit,
                    next = page.next,
                    previous = page.previous
                )
            )
        db.pokedexDao()
            .insertAll(
                *page
                    .items
                    .map { item ->
                        PokedexItem(
                            id = item.id,
                            name = item.name
                        )
                    }
                    .toTypedArray()
            )
    }

}
