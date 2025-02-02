package com.holmes.list.feature.week

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.ui.theme.ListTheme

/**
 * 周刊页路由
 */
@Composable
fun WeekRoute() {

    WeekScreen()
}

/**
 * 周刊页函数
 */
@Composable
fun WeekScreen() {
    Text(text = "周刊页")
}

/**
 * 周刊页预览函数
 */
@Preview
@Composable
private fun WeekScreenPreview(): Unit {
    ListTheme {
        WeekScreen()
    }
}