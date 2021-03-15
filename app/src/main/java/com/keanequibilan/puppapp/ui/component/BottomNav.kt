package com.keanequibilan.puppapp.ui.component

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import com.keanequibilan.puppapp.ui.navigation.BottomNavigationItems

@Composable
fun BottomNav(
    navController: NavHostController,
    items: List<BottomNavigationItems>
) {
    BottomAppBar {
        val currentRoute = currentRoute(navController = navController)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = screen.name
                    )
                },
                label = {
                    Text(
                        text = screen.name
                    )
                },
                onClick = {
                    if (currentRoute != screen.route) {
                        navController.navigate(screen.route)
                    }
                },
                selected = currentRoute == screen.route
            )
        }
    }
}

@Composable
fun currentRoute(
    navController: NavHostController
): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
}
