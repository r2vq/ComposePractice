package com.keanequibilan.puppapp.ui.page.pokemonlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.keanequibilan.puppapp.app.usecase.PokemonListUseCase
import com.keanequibilan.puppapp.ui.model.PokemonListItem
import kotlinx.coroutines.launch

class PokemonListViewModel(
    val useCase: PokemonListUseCase
) : ViewModel() {
    private val mutableItems = MutableLiveData(emptyList<PokemonListItem>())
    val items: LiveData<List<PokemonListItem>> = mutableItems

    init {
        viewModelScope.launch {
            useCase
                .getList()
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
