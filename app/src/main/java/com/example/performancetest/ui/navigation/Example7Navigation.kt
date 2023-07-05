package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example7.Example7AScreen
import com.example.performancetest.ui.examples.example7.Example7AViewModel
import com.example.performancetest.ui.examples.example7.Example7BScreen
import com.example.performancetest.ui.examples.example7.Example7BViewModel
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example7Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example7.route,
        route = MenuScreen.Example7.root()
    ) {
        composable(route = MenuScreen.Example7.route) {
            MenuList(
                title = MenuScreen.Example7.title,
                items = listOf(
                    MenuScreen.Example7A,
                    MenuScreen.Example7B
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example7A.route) { Example7AScreen(MenuScreen.Example7A.title, Example7AViewModel()) }
        composable(route = MenuScreen.Example7B.route) { Example7BScreen(MenuScreen.Example7B.title, Example7BViewModel()) }
    }
}
