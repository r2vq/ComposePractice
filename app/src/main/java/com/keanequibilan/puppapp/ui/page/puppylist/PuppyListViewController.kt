package com.keanequibilan.puppapp.ui.page.puppylist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import com.keanequibilan.puppapp.ui.component.PuppyItem

@Composable
fun PuppyListViewController(
    viewModel: PuppyListViewModel
) {
    Surface(color = MaterialTheme.colors.background) {
        MaterialTheme {
            PuppyList(viewModel.items.observeAsState(emptyList()))
        }
    }
}

@Composable
fun PuppyList(
    puppies: State<List<String>>
) {
    LazyColumn {
        items(
            count = puppies.value.size
        ) { index ->
            PuppyItem(puppies.value[index])
        }
    }
}
