package com.keanequibilan.puppapp.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.keanequibilan.puppapp.ui.model.TitlePokedexItem

@Composable
fun TitlePokedexComponent(
    item: TitlePokedexItem,
    modifier: Modifier = Modifier
) {
    Text(
        text = item.title,
        style = MaterialTheme.typography.h1,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    )
}
