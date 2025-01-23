package com.holmes.list.feature.habit

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.holmes.list.feature.habit.HabitRoute

const val HABIT_ROUTE = "habit"

fun NavGraphBuilder.habitScreen(
    toMain:() -> Unit,
) {
    composable(HABIT_ROUTE) {
        HabitRoute(
        )
    }
}