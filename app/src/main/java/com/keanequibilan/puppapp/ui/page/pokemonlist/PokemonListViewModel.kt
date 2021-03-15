package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertHeaderItem
import androidx.paging.map
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.LocalPokemon
import com.keanequibilan.puppapp.repository.model.PokedexItem
import com.keanequibilan.puppapp.ui.model.PokedexListItem
import com.keanequibilan.puppapp.ui.model.PokemonPokedexItem
import com.keanequibilan.puppapp.ui.model.PokemonType
import com.keanequibilan.puppapp.ui.model.TitlePokedexItem
import com.keanequibilan.puppapp.ui.theme.PokemonTypeColour
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class PokemonListViewModel(
    pager: Pager<Int, PokedexItem>,
    repository: PokemonRepository
) : ViewModel() {
    val pokedexItems: Flow<PagingData<PokedexListItem>> = pager
        .flow
        .map { pagingData ->
            pagingData
                .map {
                    repository.getPokemon(it.id)
                }
                .map { localItem ->
                    localItem.toPokedexListItem()
                }
                .insertHeaderItem(
                    item = TitlePokedexItem(
                        "Pokedex"
                    )
                )
        }
        .cachedIn(viewModelScope)
}

private fun LocalPokemon.toPokedexListItem(): PokedexListItem {
    return PokemonPokedexItem(
        id = id,
        name = name.capitalize(Locale.ROOT),
        spriteFront = spriteFront,
        officialArtwork = officialArtwork,
        types = types.map {
            PokemonType(
                name = it.name.capitalize(Locale.ROOT)
            )
        },
        typeColour = when (types.firstOrNull()?.name) {
            "normal" -> PokemonTypeColour.Normal
            "fighting" -> PokemonTypeColour.Fighting
            "flying" -> PokemonTypeColour.Flying
            "poison" -> PokemonTypeColour.Poison
            "ground" -> PokemonTypeColour.Ground
            "rock" -> PokemonTypeColour.Rock
            "bug" -> PokemonTypeColour.Bug
            "ghost" -> PokemonTypeColour.Ghost
            "steel" -> PokemonTypeColour.Steel
            "fire" -> PokemonTypeColour.Fire
            "water" -> PokemonTypeColour.Water
            "grass" -> PokemonTypeColour.Grass
            "electric" -> PokemonTypeColour.Electric
            "psychic" -> PokemonTypeColour.Psychic
            "ice" -> PokemonTypeColour.Ice
            "dragon" -> PokemonTypeColour.Dragon
            "dark" -> PokemonTypeColour.Dark
            "fairy" -> PokemonTypeColour.Fairy
            "unknown" -> PokemonTypeColour.Unknown
            "shadow" -> PokemonTypeColour.Shadow
            else -> PokemonTypeColour.Unknown
        }
    )
}
