package com.holmes.list.feature.list

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.holmes.list.feature.list.ListRoute

const val LIST_ROUTE = "list"

fun NavGraphBuilder.listScreen(
    toMain:() -> Unit,
) {
    composable(LIST_ROUTE) {
        ListRoute(
        )
    }
}