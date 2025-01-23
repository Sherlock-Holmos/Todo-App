package com.holmes.list.feature.week

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val WEEK_ROUTE = "week"

fun NavGraphBuilder.weekScreen(
    toMain:() -> Unit,
) {
    composable(WEEK_ROUTE) {
        WeekRoute(
        )
    }
}