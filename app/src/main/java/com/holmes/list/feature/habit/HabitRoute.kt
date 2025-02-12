package com.holmes.list.feature.habit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.feature.habit.component.DividerWithText
import com.holmes.list.feature.habit.component.HabitOnDisplay
import com.holmes.list.feature.habit.component.HabitOutDisplay
import com.holmes.list.feature.habit.component.HabitTitleBar
import com.holmes.list.feature.week.component.WeekListContainer
import com.holmes.list.feature.week.component.WeekTitleBar
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
    Scaffold(
        topBar = {
            HabitTitleBar()
        }
    ) {paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            DividerWithText(text = "进行中")
            HabitOnDisplay()
            DividerWithText(text = "已完成")
            HabitOutDisplay()
        }
    }
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