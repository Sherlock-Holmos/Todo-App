package com.holmes.list.feature.main

import com.holmes.list.R
import com.holmes.list.feature.habit.HABIT_ROUTE
import com.holmes.list.feature.list.LIST_ROUTE
import com.holmes.list.feature.mine.MINE_ROUTE
import com.holmes.list.feature.week.WEEK_ROUTE

enum class TopLevelDestination(
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val titleTextId: Int,
    val route: String,
) {
    LIST(
        unselectedIcon = R.drawable.tab_list,
        selectedIcon = R.drawable.tab_list_selected,
        titleTextId = R.string.tab_list_name,
        route = LIST_ROUTE
    ),

    WEEK(
        unselectedIcon = R.drawable.tab_week,
        selectedIcon = R.drawable.tab_week_selected,
        titleTextId = R.string.tab_week_name,
        route = WEEK_ROUTE
    ),

    HABIT(
        unselectedIcon = R.drawable.tab_habit,
        selectedIcon = R.drawable.tab_habit_selected,
        titleTextId = R.string.tab_habit_name,
        route = HABIT_ROUTE
    ),

    MINE(
        unselectedIcon = R.drawable.tab_mine,
        selectedIcon = R.drawable.tab_mine_selected,
        titleTextId = R.string.tab_mine_name,
        route = MINE_ROUTE
    )
}