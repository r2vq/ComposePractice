package com.keanequibilan.puppapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItems(
    val route: String,
    val name: String,
    val icon: ImageVector
) {
    object Puppies : BottomNavigationItems(
        "puppies",
        "Puppies",
        Icons.Filled.Face
    )

    object Anime : BottomNavigationItems(
        "anime",
        "Anime",
        Icons.Filled.Person
    )
}
