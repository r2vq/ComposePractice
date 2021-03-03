package com.keanequibilan.puppapp.ui.page.puppylist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.keanequibilan.puppapp.ui.component.PuppyItem

class PuppyListViewController(
    private val viewModel: PuppyListViewModel
) {

    @Composable
    fun Compose() {
        Surface(color = MaterialTheme.colors.background) {
            MaterialTheme {
                Greeting(viewModel.items.observeAsState(emptyList()))
            }
        }
    }

    @Composable
    private fun Greeting(puppies: State<List<String>>) {
        LazyColumn {
            items(
                count = puppies.value.size
            ) { index ->
                PuppyItem(puppies.value[index]).Compose()
            }
        }
    }
}
