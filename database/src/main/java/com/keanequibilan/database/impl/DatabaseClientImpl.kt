package com.keanequibilan.database.impl

import com.keanequibilan.database.AppDatabase
import com.keanequibilan.database.DatabaseClient
import com.keanequibilan.database.entity.PokedexItem
import com.keanequibilan.database.entity.PokedexPage
import com.keanequibilan.database.model.StoredPokedexItem
import com.keanequibilan.database.model.StoredPokedexPage

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
