package com.holmes.list.feature.setting

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.holmes.list.feature.setting.SettingRoute

const val Setting_ROUTE = "setting"

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.settingScreen(
    toMain:() -> Unit,
) {
    composable(Setting_ROUTE) {
        SettingRoute(
        )
    }
}