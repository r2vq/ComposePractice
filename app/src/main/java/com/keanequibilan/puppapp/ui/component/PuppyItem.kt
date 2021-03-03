package com.keanequibilan.puppapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.ui.util.loadPicture

class PuppyItem(
    private val url: String
) {
    @Composable
    fun Compose() {
        Column {
            DogImage(url = url)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

    @Composable
    fun DogImage(url: String) {
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
