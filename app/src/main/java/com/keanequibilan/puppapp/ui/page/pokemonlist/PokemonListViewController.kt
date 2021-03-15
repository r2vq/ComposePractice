package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.keanequibilan.puppapp.ui.component.PokemonListItemComponent
import com.keanequibilan.puppapp.ui.model.PokemonListItem

@Composable
fun PokemonListViewScreen(
    viewModel: PokemonListViewModel
) {
    Surface(color = MaterialTheme.colors.background) {
        MaterialTheme {
            PokemonList(viewModel.pokedexItems.collectAsLazyPagingItems())
        }
    }
}

@Composable
private fun PokemonList(pokemonList: LazyPagingItems<PokemonListItem>) {
    LazyColumn {
        items(pokemonList) { item ->
            item?.let { PokemonListItemComponent(it) }
        }
    }
}
