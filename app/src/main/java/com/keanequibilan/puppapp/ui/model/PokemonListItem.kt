package com.keanequibilan.puppapp.ui.model

import android.net.Uri
import com.keanequibilan.puppapp.ui.theme.PokemonTypeColour

data class PokemonListItem(
    val id: Int,
    val name: String,
    val spriteFront: Uri,
    val officialArtwork: Uri,
    val types: List<PokemonType>,
    val typeColour: PokemonTypeColour
)

data class PokemonType(
    val name: String
)
