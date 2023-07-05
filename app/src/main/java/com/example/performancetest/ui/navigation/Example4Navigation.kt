package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example4.Example4AScreen
import com.example.performancetest.ui.examples.example4.Example4AViewModel
import com.example.performancetest.ui.examples.example4.Example4BScreen
import com.example.performancetest.ui.examples.example4.Example4BViewModel
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example4Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example4.route,
        route = MenuScreen.Example4.root()
    ) {
        composable(route = MenuScreen.Example4.route) {
            MenuList(
                title = MenuScreen.Example4.title,
                items = listOf(
                    MenuScreen.Example4A,
                    MenuScreen.Example4B
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example4A.route) { Example4AScreen(MenuScreen.Example4A.title, Example4AViewModel()) }
        composable(route = MenuScreen.Example4B.route) { Example4BScreen(MenuScreen.Example4B.title, Example4BViewModel()) }
    }
}
