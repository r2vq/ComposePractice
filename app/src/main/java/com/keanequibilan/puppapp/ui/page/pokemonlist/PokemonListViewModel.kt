package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.PokedexItem
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PokemonListViewModel(
    pager: Pager<Int, PokedexItem>,
    repository: PokemonRepository
) : ViewModel() {
    val pokedexItems: Flow<PagingData<PokemonListItem>> = pager
        .flow
        .map { pagingData ->
            pagingData
                .map {
                    repository.getPokemon(it.id)
                }
                .map { item ->
                    PokemonListItem(
                        id = item.id,
                        name = item.name,
                        spriteFront = item.spriteFront,
                        officialArtwork = item.officialArtwork
                    )
                }
        }
        .cachedIn(viewModelScope)
}
