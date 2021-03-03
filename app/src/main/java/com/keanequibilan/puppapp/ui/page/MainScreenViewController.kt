package com.keanequibilan.puppapp.ui.page

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.keanequibilan.puppapp.ui.component.BottomNav
import com.keanequibilan.puppapp.ui.navigation.BottomNavigationItems
import com.keanequibilan.puppapp.ui.navigation.MainNavigationConfiguration

/**
 * Implementation for this taken from:
 * https://proandroiddev.com/implement-bottom-bar-navigation-in-jetpack-compose-b530b1cd9ee2
 */
class MainScreenViewController(
    private val bottomNav: BottomNav,
    private val mainScreenNavigationConfiguration: MainNavigationConfiguration
) {
    @Composable
    fun Compose() {
        val navController = rememberNavController()

        val navItems = remember {
            listOf(
                BottomNavigationItems.Puppies,
                BottomNavigationItems.Anime
            )
        }

        Scaffold(
            bottomBar = {
                bottomNav.Compose(
                    navController = navController,
                    items = navItems
                )
            }
        ) {
            mainScreenNavigationConfiguration.Compose(
                navController = navController
            )
        }
    }
}
