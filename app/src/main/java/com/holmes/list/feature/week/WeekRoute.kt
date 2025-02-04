package com.holmes.list.feature.week

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.feature.week.component.WeekListContainer
import com.holmes.list.feature.week.component.WeekTitleBar
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
    Scaffold(
        topBar = {
            WeekTitleBar()
        }
    ) {paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {
            WeekListContainer()
        }
    }
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