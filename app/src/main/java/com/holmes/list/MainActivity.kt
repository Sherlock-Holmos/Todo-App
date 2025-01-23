package com.holmes.list

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.holmes.list.ui.MyApp
import com.holmes.list.ui.theme.ListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //显示到状态栏
        enableEdgeToEdge()

        //状态栏文字颜色变更为白色并显示到状态栏
        //enableEdgeToEdge(statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT))

        setContent {
            val navController = rememberNavController()

            ListTheme {
                MyApp(
                    navController = navController
                )
            }
        }
    }
}
