package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example6.Example6AScreen
import com.example.performancetest.ui.examples.example6.Example6AViewModel
import com.example.performancetest.ui.examples.example6.Example6BScreen
import com.example.performancetest.ui.examples.example6.Example6BViewModel
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example6Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example6.route,
        route = MenuScreen.Example6.root()
    ) {
        composable(route = MenuScreen.Example6.route) {
            MenuList(
                title = MenuScreen.Example6.title,
                items = listOf(
                    MenuScreen.Example6A,
                    MenuScreen.Example6B
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example6A.route) { Example6AScreen(MenuScreen.Example6A.title, Example6AViewModel()) }
        composable(route = MenuScreen.Example6B.route) { Example6BScreen(MenuScreen.Example6B.title, Example6BViewModel()) }
    }
}
