package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.keanequibilan.puppapp.ui.component.PokemonListItemComponent
import com.keanequibilan.puppapp.ui.model.PokemonListItem

class PokemonListViewController(
    private val viewModel: PokemonListViewModel
) {
    @Composable
    fun Compose() {
        Surface(color = MaterialTheme.colors.background) {
            MaterialTheme {
                PokemonList(viewModel.items.observeAsState(emptyList()))
            }
        }
    }

    @Composable
    private fun PokemonList(pokemonList: State<List<PokemonListItem>>) {
        LazyColumn {
            items(
                count = pokemonList.value.size
            ) { index ->
                PokemonListItemComponent(pokemonList.value[index]).Compose()
            }
        }
    }
}
