package com.keanequibilan.puppapp

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.keanequibilan.puppapp.ui.page.MainScreenViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel
import com.keanequibilan.puppapp.ui.theme.PuppAppTheme
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val puppyListViewModel: PuppyListViewModel by viewModel()
    private val animeListViewModel: AnimeListViewModel by viewModel()
    private val pokemonListViewModel: PokemonListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppAppTheme {
                MainScreenViewController(
                    pokemonListViewModel = pokemonListViewModel,
                    animeListViewModel = animeListViewModel,
                    puppyListViewModel = puppyListViewModel
                )
            }
        }
    }
}
