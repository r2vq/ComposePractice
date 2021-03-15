package com.keanequibilan.puppapp.ui.page

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.keanequibilan.puppapp.ui.component.BottomNav
import com.keanequibilan.puppapp.ui.navigation.BottomNavigationItems
import com.keanequibilan.puppapp.ui.navigation.MainNavigationConfiguration
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel

/**
 * Implementation for this taken from:
 * https://proandroiddev.com/implement-bottom-bar-navigation-in-jetpack-compose-b530b1cd9ee2
 */
@Composable
fun MainScreenViewController(
    puppyListViewModel: PuppyListViewModel,
    animeListViewModel: AnimeListViewModel,
    pokemonListViewModel: PokemonListViewModel
) {
    val navController = rememberNavController()

    val navItems = remember {
        listOf(
            BottomNavigationItems.Puppies,
            BottomNavigationItems.Anime,
            BottomNavigationItems.Pokemon
        )
    }

    Scaffold(
        bottomBar = {
            BottomNav(
                navController = navController,
                items = navItems
            )
        }
    ) {
        Box(modifier = Modifier.padding(bottom = 58.dp)) {
            MainNavigationConfiguration(
                navController = navController,
                puppyListViewModel = puppyListViewModel,
                animeListViewModel = animeListViewModel,
                pokemonListViewModel = pokemonListViewModel
            )
        }
    }
}
