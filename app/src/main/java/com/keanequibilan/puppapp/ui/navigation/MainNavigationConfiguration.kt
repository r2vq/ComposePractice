package com.keanequibilan.puppapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.keanequibilan.puppapp.ui.page.animelist.AnimeListViewController
import com.keanequibilan.puppapp.ui.page.pokemonlist.PokemonListViewController
import com.keanequibilan.puppapp.ui.page.puppylist.PuppyListViewController

class MainNavigationConfiguration(
    private val puppyListViewController: PuppyListViewController,
    private val animeListViewController: AnimeListViewController,
    private val pokemonListViewController: PokemonListViewController
) {
    @Composable
    fun Compose(
        navController: NavHostController
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavigationItems.Puppies.route
        ) {
            composable(BottomNavigationItems.Puppies.route) {
                puppyListViewController.Compose()
            }
            composable(BottomNavigationItems.Anime.route) {
                animeListViewController.Compose()
            }
            composable(BottomNavigationItems.Pokemon.route) {
                pokemonListViewController.Compose()
            }
        }
    }
}
