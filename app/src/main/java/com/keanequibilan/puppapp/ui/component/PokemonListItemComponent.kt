package com.keanequibilan.puppapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import com.keanequibilan.puppapp.ui.util.loadPicture

class PokemonListItemComponent(private val item: PokemonListItem) {
    @Composable
    fun Compose() {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeightIn(
                    min = 125.dp
                )
                .padding(8.dp)
                .shadow(4.dp)
        ) {
            Column {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
                PokemonImage(url = item.officialArtwork.toString())
            }
        }
    }

    @Composable
    fun PokemonImage(url: String) {
        loadPicture(url = url)
            .value
            ?.asImageBitmap()
            ?.let { bitmap ->
                Image(
                    bitmap = bitmap,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(4.dp),
                    contentScale = ContentScale.FillWidth
                )
            }
    }
}
