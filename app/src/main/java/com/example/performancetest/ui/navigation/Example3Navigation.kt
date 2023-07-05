package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example3.Example3AScreen
import com.example.performancetest.ui.examples.example3.Example3AViewModel
import com.example.performancetest.ui.examples.example3.Example3BScreen
import com.example.performancetest.ui.examples.example3.Example3BViewModel
import com.example.performancetest.ui.examples.example3.Example3CScreen
import com.example.performancetest.ui.examples.example3.Example3CViewModel
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example3Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example3.route,
        route = MenuScreen.Example3.root()
    ) {
        composable(route = MenuScreen.Example3.route) {
            MenuList(
                title = MenuScreen.Example3.title,
                items = listOf(
                    MenuScreen.Example3A,
                    MenuScreen.Example3B,
                    MenuScreen.Example3C
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example3A.route) { Example3AScreen(MenuScreen.Example3A.title, Example3AViewModel()) }
        composable(route = MenuScreen.Example3B.route) { Example3BScreen(MenuScreen.Example3B.title, Example3BViewModel()) }
        composable(route = MenuScreen.Example3C.route) { Example3CScreen(MenuScreen.Example3C.title, Example3CViewModel()) }
    }
}