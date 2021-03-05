package com.keanequibilan.puppapp.di

import com.keanequibilan.puppapp.network.DogService
import com.keanequibilan.puppapp.network.JikanService
import com.keanequibilan.puppapp.network.PokemonService
import com.keanequibilan.puppapp.ui.component.BottomNav
import com.keanequibilan.puppapp.ui.navigation.MainNavigationConfiguration
import com.keanequibilan.puppapp.ui.page.MainScreenViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewController
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel
import com.keanequibilan.puppapp.app.usecase.PokemonListUseCase
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val APP_MODULE = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(get())
            .build()
            .create(DogService::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(get())
            .build()
            .create(JikanService::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://pokeapi.co/")
            .addConverterFactory(get())
            .build()
            .create(PokemonService::class.java)
    }

    single {
        PokemonListUseCase(
            api = get()
        )
    }

    single<Converter.Factory> {
        MoshiConverterFactory.create()
    }

    viewModel {
        AnimeListViewModel(
            api = get()
        )
    }

    viewModel {
        PokemonListViewModel(
            useCase = get()
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
