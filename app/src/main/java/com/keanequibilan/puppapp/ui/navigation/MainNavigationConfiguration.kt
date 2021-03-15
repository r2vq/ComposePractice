package com.keanequibilan.puppapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewModel
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewScreen
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewModel

@Composable
fun MainNavigationConfiguration(
    navController: NavHostController,
    puppyListViewModel: PuppyListViewModel,
    animeListViewModel: AnimeListViewModel,
    pokemonListViewModel: PokemonListViewModel
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavigationItems.Puppies.route
    ) {
        composable(BottomNavigationItems.Puppies.route) {
            PuppyListViewController(puppyListViewModel)
        }
        composable(BottomNavigationItems.Anime.route) {
            AnimeListViewController(animeListViewModel)
        }
        composable(BottomNavigationItems.Pokemon.route) {
            PokemonListViewScreen(pokemonListViewModel)
        }
    }
}
