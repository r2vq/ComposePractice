package com.keanequibilan.puppapp.di

import com.keanequibilan.puppapp.ui.component.BottomNav
import com.keanequibilan.puppapp.ui.navigation.MainNavigationConfiguration
import com.keanequibilan.puppapp.ui.page.MainScreenViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewController
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController
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
            repo = get()
        )
    }

    viewModel {
        PuppyListViewModel(
            api = get()
        )
    }

    single {
        MainNavigationConfiguration(
            puppyListViewController = get(),
            animeListViewController = get(),
            pokemonListViewController = get()
        )
    }

    factory {
        BottomNav()
    }

    factory {
        MainScreenViewController(
            bottomNav = get(),
            mainScreenNavigationConfiguration = get()
        )
    }

    factory {
        AnimeListViewController(
            viewModel = get()
        )
    }

    factory {
        PokemonListViewController(
            viewModel = get()
        )
    }

    factory {
        PuppyListViewController(
            viewModel = get()
        )
    }
}
