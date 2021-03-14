package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.repository.model.PokedexItem
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import com.keanequibilan.puppapp.ui.model.PokemonType
import com.keanequibilan.puppapp.ui.theme.PokemonTypeColour
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.*

class PokemonListViewModel(
    pager: Pager<Int, PokedexItem>,
    repository: PokemonRepository
) : ViewModel() {
    val pokedexItems: Flow<PagingData<PokemonListItem>> = pager
        .flow
        .map { pagingData ->
            pagingData
                .map {
                    repository.getPokemon(it.id)
                }
                .map { item ->
                    PokemonListItem(
                        id = item.id,
                        name = item.name.capitalize(Locale.ROOT),
                        spriteFront = item.spriteFront,
                        officialArtwork = item.officialArtwork,
                        types = item.types.map {
                            PokemonType(
                                name = it.name.capitalize(Locale.ROOT)
                            )
                        },
                        typeColour = when (item.types.firstOrNull()?.name) {
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
        }
        .cachedIn(viewModelScope)
}
