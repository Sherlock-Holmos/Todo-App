package com.holmes.list.feature.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.holmes.list.feature.list.ListRoute

const val LIST_ROUTE = "list"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.listScreen(
    toMain:() -> Unit,
) {
    composable(LIST_ROUTE) {
        ListRoute(
        )
    }
}