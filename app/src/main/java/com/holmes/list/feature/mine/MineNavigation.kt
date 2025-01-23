package com.holmes.list.feature.mine

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val MINE_ROUTE = "mine"

fun NavGraphBuilder.splashScreen(
    toMain:() -> Unit,
) {
    composable(MINE_ROUTE) {
        MineRoute(
        )
    }
}