package com.keanequibilan.puppapp.ui.model

import android.net.Uri

data class PokemonListItem(
    val id: Int,
    val name: String,
    val spriteFront: Uri,
    val officialArtwork: Uri
)
