package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example8.Example8AScreen
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example8Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example8.route,
        route = MenuScreen.Example8.root()
    ) {
        composable(route = MenuScreen.Example8.route) {
            MenuList(
                title = MenuScreen.Example8.title,
                items = listOf(
                    MenuScreen.Example8A
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example8A.route) { Example8AScreen(MenuScreen.Example8A.title) }
    }
}
