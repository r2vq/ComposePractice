package com.keanequibilan.puppapp.ui.model

import android.net.Uri
import com.keanequibilan.puppapp.ui.theme.PokemonTypeColour

sealed class PokedexListItem

data class TitlePokedexItem(
    val title: String
) : PokedexListItem()

data class PokemonPokedexItem(
    val id: Int,
    val name: String,
    val spriteFront: Uri,
    val officialArtwork: Uri?,
    val types: List<PokemonType>,
    val typeColour: PokemonTypeColour
) : PokedexListItem()

data class PokemonType(
    val name: String
)
