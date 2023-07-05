package com.example.performancetest.ui.menu

sealed class MenuScreen(val title: String, val route: String) {
    object Main : MenuScreen("Examples", "menu")

    object Example1  : MenuScreen("Example 1: Inlined composables", "example1")
    object Example1A : MenuScreen("Example 1A: Inlined composable", "example1A")
    object Example1B : MenuScreen("Example 1B: Wrapped inlined composable", "example1B")

    object Example2  : MenuScreen("Example 2: Restartable composables", "example2")
    object Example2A : MenuScreen("Example 2A: Restartable composable", "example2A")
    object Example2B : MenuScreen("Example 2B: Non-restartable composable", "example2B")
    object Example2C : MenuScreen("Example 2C: Parameter change inside non-restartable composable", "example2C")

    object Example3  : MenuScreen("Example 3: Unstable variable parameters", "example3")
    object Example3A : MenuScreen("Example 3A: Unstable variable", "example3A")
    object Example3B : MenuScreen("Example 3B: Stabilizing variable", "example3B")
    object Example3C : MenuScreen("Example 3C: Unstable and stable parameters", "example3C")

    object Example4  : MenuScreen("Example 4: Unstable lambda parameters", "example4")
    object Example4A : MenuScreen("Example 4A: Unstable lambda", "example4A")
    object Example4B : MenuScreen("Example 4B: Stabilizing lambda", "example4B")

    object Example5  : MenuScreen("Example 5: Unstable collection parameters", "example5")
    object Example5A : MenuScreen("Example 5A: Unstable collection", "example5A")
    object Example5B : MenuScreen("Example 5B: Stabilizing collection with immutable list", "example5B")
    object Example5C : MenuScreen("Example 5C: Stabilizing collection with snapshot state list", "example5C")

    object Example6  : MenuScreen("Example 6: Lazy layout performance", "example6")
    object Example6A : MenuScreen("Example 6A: Lazy layout without key", "example6A")
    object Example6B : MenuScreen("Example 6B: Adding lazy layout key", "example6B")

    object Example7  : MenuScreen("Example 7: Use of derived state", "example7")
    object Example7A : MenuScreen("Example 7A: Button visibility by scroll state", "example7A")
    object Example7B : MenuScreen("Example 7B: Button visibility by derived state", "example7B")

    object Example8  : MenuScreen("Example 8: Avoid backwards writes", "example8")
    object Example8A : MenuScreen("Example 8A: Write parameter value directly", "example8A")

    fun root() = "${route}_root"
}
