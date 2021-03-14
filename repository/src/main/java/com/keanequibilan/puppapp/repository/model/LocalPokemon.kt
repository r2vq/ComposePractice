package com.keanequibilan.puppapp.repository.model

import android.net.Uri

data class LocalPokemon(
    val id: Int,
    val name: String,
    val spriteFront: Uri,
    val officialArtwork: Uri
)
