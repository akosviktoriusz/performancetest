package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example5.Example5AScreen
import com.example.performancetest.ui.examples.example5.Example5AViewModel
import com.example.performancetest.ui.examples.example5.Example5BScreen
import com.example.performancetest.ui.examples.example5.Example5BViewModel
import com.example.performancetest.ui.examples.example5.Example5CScreen
import com.example.performancetest.ui.examples.example5.Example5CViewModel
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example5Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example5.route,
        route = MenuScreen.Example5.root()
    ) {
        composable(route = MenuScreen.Example5.route) {
            MenuList(
                title = MenuScreen.Example5.title,
                items = listOf(
                    MenuScreen.Example5A,
                    MenuScreen.Example5B,
                    MenuScreen.Example5C
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example5A.route) { Example5AScreen(MenuScreen.Example5A.title, Example5AViewModel()) }
        composable(route = MenuScreen.Example5B.route) { Example5BScreen(MenuScreen.Example5B.title, Example5BViewModel()) }
        composable(route = MenuScreen.Example5C.route) { Example5CScreen(MenuScreen.Example5B.title, Example5CViewModel()) }
    }
}
