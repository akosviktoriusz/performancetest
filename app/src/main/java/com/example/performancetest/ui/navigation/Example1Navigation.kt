package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example1.Example1AScreen
import com.example.performancetest.ui.examples.example1.Example1BScreen
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example1Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example1.route,
        route = MenuScreen.Example1.root()
    ) {
        composable(route = MenuScreen.Example1.route) {
            MenuList(
                title = MenuScreen.Example1.title,
                items = listOf(
                    MenuScreen.Example1A,
                    MenuScreen.Example1B
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example1A.route) { Example1AScreen(MenuScreen.Example1A.title) }
        composable(route = MenuScreen.Example1B.route) { Example1BScreen(MenuScreen.Example1B.title) }
    }
}
