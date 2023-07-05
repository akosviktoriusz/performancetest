package com.example.performancetest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.performancetest.ui.menu.MenuList
import com.example.performancetest.ui.menu.MenuScreen

@Composable
fun MenuNavController() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MenuScreen.Main.route,
    ) {
        composable(route = MenuScreen.Main.route) {
            MenuList(
                title = MenuScreen.Main.title,
                items = listOf(
                    MenuScreen.Example1,
                    MenuScreen.Example2,
                    MenuScreen.Example3,
                    MenuScreen.Example4,
                    MenuScreen.Example5,
                    MenuScreen.Example6,
                    MenuScreen.Example7,
                    MenuScreen.Example8
                ),
                onItemClick = { item ->
                    navController.navigate(item.route)
                }
            )
        }
        example1Graph(navController)
        example2Graph(navController)
        example3Graph(navController)
        example4Graph(navController)
        example5Graph(navController)
        example6Graph(navController)
        example7Graph(navController)
        example8Graph(navController)
    }
}
