package com.holmes.list.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.holmes.list.feature.splash.SPLASH_ROUTE

const val MAIN_ROUTE = "main"

/**
 * 跳转到主页面
 */
fun NavController.navigateToMain(): Unit {
    navigate(MAIN_ROUTE){
        launchSingleTop = true //跳转时只跳转一个页面

        popUpTo(SPLASH_ROUTE){
            inclusive = true  //跳转时关闭Splash以及之前的所有页面
        }
    }
}

/**
 * 配置导航
 */
fun NavGraphBuilder.mainScreen() {
    composable(MAIN_ROUTE) {
        MainRoute()
    }
}