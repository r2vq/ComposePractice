package com.keanequibilan.puppapp.ui.page.animelist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.keanequibilan.puppapp.ui.component.AnimeItem
import com.keanequibilan.puppapp.ui.model.Anime

class AnimeListViewController(
    private val viewModel: AnimeListViewModel
) {
    @Composable
    fun Compose() {
        Surface(color = MaterialTheme.colors.background) {
            MaterialTheme {
                AnimeList(viewModel.items.observeAsState(emptyList()))
            }
        }
    }

    @Composable
    private fun AnimeList(anime: State<List<Anime>>) {
        LazyColumn {
            items(
                count = anime.value.size
            ) { index ->
                AnimeItem(anime.value[index]).Compose()
            }
        }
    }
}
