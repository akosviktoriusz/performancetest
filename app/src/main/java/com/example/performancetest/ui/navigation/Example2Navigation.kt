package com.example.performancetest.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.performancetest.ui.examples.example2.Example2AScreen
import com.example.performancetest.ui.examples.example2.Example2BScreen
import com.example.performancetest.ui.examples.example2.Example2CScreen
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

fun NavGraphBuilder.example2Graph(navController: NavController) {
    navigation(
        startDestination = MenuScreen.Example2.route,
        route = MenuScreen.Example2.root()
    ) {
        composable(route = MenuScreen.Example2.route) {
            MenuList(
                title = MenuScreen.Example2.title,
                items = listOf(
                    MenuScreen.Example2A,
                    MenuScreen.Example2B,
                    MenuScreen.Example2C
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        composable(route = MenuScreen.Example2A.route) { Example2AScreen(MenuScreen.Example2A.title) }
        composable(route = MenuScreen.Example2B.route) { Example2BScreen(MenuScreen.Example2B.title) }
        composable(route = MenuScreen.Example2C.route) { Example2CScreen(MenuScreen.Example2C.title) }
    }
}
