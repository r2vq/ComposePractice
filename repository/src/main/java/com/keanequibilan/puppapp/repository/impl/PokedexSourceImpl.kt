package com.keanequibilan.puppapp.repository.impl

import android.util.Log
import androidx.paging.PagingState
import com.keanequibilan.puppapp.repository.PokedexSource
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.PokedexItem

internal class PokedexSourceImpl(
    private val pokemonRepository: PokemonRepository
) : PokedexSource() {

    override fun getRefreshKey(state: PagingState<Int, PokedexItem>): Int? = state
        .anchorPosition
        ?.let { state.closestPageToPosition(it) }
        ?.run { prevKey?.plus(1) ?: nextKey?.minus(1) }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokedexItem> = try {
        val nextPage = params.key ?: 0
        val pokedexItemsResponse = pokemonRepository.getPokedex(nextPage)

        LoadResult.Page(
            data = pokedexItemsResponse.items,
            prevKey = pokedexItemsResponse.previous,
            nextKey = pokedexItemsResponse.next
        )
    } catch (e: Exception) {
        Log.e("Keane", "Error at Source or lower", e)
        LoadResult.Error(e)
    }
}
