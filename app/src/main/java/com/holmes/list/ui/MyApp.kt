package com.holmes.list.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.holmes.list.feature.main.mainScreen
import com.holmes.list.feature.main.navigateToMain
import com.holmes.list.feature.setting.settingScreen
import com.holmes.list.feature.splash.SPLASH_ROUTE
import com.holmes.list.feature.splash.SplashRoute
import com.holmes.list.feature.splash.splashScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyApp(navController: NavHostController) {
    NavHost(navController = navController, startDestination = SPLASH_ROUTE){
        splashScreen(
            toMain = navController::navigateToMain
        )
        mainScreen()

    }
}