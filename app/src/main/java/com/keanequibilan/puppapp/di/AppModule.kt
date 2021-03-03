package com.keanequibilan.puppapp.di

import com.keanequibilan.puppapp.network.DogService
import com.keanequibilan.puppapp.network.JikanService
import com.keanequibilan.puppapp.ui.component.BottomNav
import com.keanequibilan.puppapp.ui.navigation.MainNavigationConfiguration
import com.keanequibilan.puppapp.ui.page.MainScreenViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val APP_MODULE = module {

    single {
        Retrofit.Builder()
            .baseUrl("https://dog.ceo/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(DogService::class.java)
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.jikan.moe/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(JikanService::class.java)
    }

    viewModel {
        AnimeListViewModel(
            api = get()
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
            animeListViewController = get()
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
        PuppyListViewController(
            viewModel = get()
        )
    }
}
