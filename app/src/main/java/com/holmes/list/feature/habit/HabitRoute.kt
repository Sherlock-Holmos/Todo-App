package com.holmes.list.feature.habit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.ui.theme.ListTheme

/**
 * 习惯页路由
 */
@Composable
fun HabitRoute() {
    HabitScreen()
}

/**
 * 习惯页函数
 */
@Composable
fun HabitScreen() {
    Text(text = "习惯页")
}

/**
 * 习惯页预览函数
 */
@Preview
@Composable
private fun HabitScreenPreview(): Unit {
    ListTheme {
        HabitScreen()
    }
}