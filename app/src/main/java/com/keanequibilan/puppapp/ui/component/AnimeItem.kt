package com.keanequibilan.puppapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.ui.model.Anime
import com.keanequibilan.puppapp.ui.util.loadPicture

class AnimeItem(
    private val anime: Anime
) {
    @Composable
    fun Compose() = with(anime) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .requiredHeightIn(
                    min = 50.dp
                )
                .shadow(4.dp)
        ) {
            Column {
                TypeBar(
                    colour = colour
                )
                Row {
                    AnimeThumbnail(
                        image = image
                    )
                    AnimeText(
                        title = title
                    )
                }
            }
        }
    }

    @Composable
    fun TypeBar(colour: Color) {
        Box(
            modifier = Modifier
                .background(
                    color = colour
                )
                .fillMaxWidth()
                .height(20.dp)
        )
    }

    @Composable
    fun AnimeText(title: String) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .padding(16.dp)
        )
    }

    @Composable
    fun AnimeThumbnail(image: String) {
        loadPicture(url = image)
            .value
            ?.asImageBitmap()
            ?.let { bitmap ->
                Image(
                    bitmap = bitmap,
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp),
                    contentScale = ContentScale.Crop
                )
            }
    }
}
