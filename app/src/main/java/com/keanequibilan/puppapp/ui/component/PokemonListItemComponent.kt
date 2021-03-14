package com.keanequibilan.puppapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.R
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import com.keanequibilan.puppapp.ui.util.loadPicture

class PokemonListItemComponent(private val item: PokemonListItem) {
    @Composable
    fun Compose() {
        Card(
            shape = RoundedCornerShape(25.dp),
            modifier = Modifier
                .fillMaxWidth()
                .requiredHeight(200.dp)
                .padding(8.dp)
        ) {
            Column {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_pokeball),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary),
                            modifier = Modifier
                                .requiredWidth(200.dp)
                                .fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopStart
                        )
                        PokemonImage(
                            url = item.officialArtwork.toString(),
                        )
                    }
                }
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
                        .requiredWidth(150.dp)
                        .offset(
                            x = (-50).dp
                        ),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.TopStart,
                )
            }
    }
}
