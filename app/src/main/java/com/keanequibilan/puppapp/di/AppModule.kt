package com.keanequibilan.puppapp.di

import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val APP_MODULE = module {
    viewModel {
        AnimeListViewModel(
            api = get()
        )
    }

    viewModel {
        PokemonListViewModel(
            pager = get(),
            repository = get()
        )
    }

    viewModel {
        PuppyListViewModel(
            api = get()
        )
    }
}
