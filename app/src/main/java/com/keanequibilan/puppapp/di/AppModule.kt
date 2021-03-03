package com.keanequibilan.puppapp.di

import com.keanequibilan.puppapp.network.DogService
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

    viewModel {
        PuppyListViewModel(
            api = get()
        )
    }

    factory {
        PuppyListViewController(
            viewModel = get()
        )
    }
}
