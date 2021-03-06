package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.puppapp.repository.PokemonRepository
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import kotlinx.coroutines.launch

class PokemonListViewModel(
    val repo: PokemonRepository
) : ViewModel() {
    private val mutableItems = MutableLiveData(emptyList<PokemonListItem>())
    val items: LiveData<List<PokemonListItem>> = mutableItems

    init {
        viewModelScope.launch {
            repo
                .getPokedex()
                .map { item ->
                    PokemonListItem(
                        id = item.id,
                        name = item.name
                    )
                }
                .let { mutableItems.postValue(it) }
        }
    }
}
