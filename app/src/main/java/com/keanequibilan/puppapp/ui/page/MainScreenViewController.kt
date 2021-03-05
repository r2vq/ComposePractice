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
                BottomNavigationItems.Anime,
                BottomNavigationItems.Pokemon
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
            Box(modifier = Modifier.padding(bottom = 58.dp)) {
                mainScreenNavigationConfiguration.Compose(
                    navController = navController
                )
            }
        }
    }
}
