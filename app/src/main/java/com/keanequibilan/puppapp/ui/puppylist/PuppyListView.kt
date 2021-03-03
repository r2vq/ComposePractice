package com.keanequibilan.puppapp.ui.puppylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.ui.util.loadPicture

@Composable
fun PuppyListView(puppyListViewModel: PuppyListViewModel) {
    Surface(color = MaterialTheme.colors.background) {
        MaterialTheme {
            Greeting(puppyListViewModel.items.observeAsState(emptyList()))
        }
    }
}

@Composable
private fun Greeting(puppies: State<List<String>>) {
    LazyColumn {
        items(
            count = puppies.value.size
        ) { index ->
            puppies
                .value[index]
                .let { url ->
                    loadPicture(url = url)
                        .value
                        ?.let { bitmap ->
                            Image(
                                bitmap = bitmap.asImageBitmap(),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(),
                                contentScale = ContentScale.FillWidth
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                        }
                }
        }
    }
}
