package com.holmes.list.feature.mine

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.holmes.list.feature.mine.component.MineTitleBar
import com.holmes.list.feature.week.component.WeekListContainer
import com.holmes.list.feature.week.component.WeekTitleBar
import com.holmes.list.ui.theme.ListTheme

/**
 * 我的页路由
 */
@Composable
fun MineRoute() {

    MineScreen()
}

/**
 * 我的页函数
 */
@Composable
fun MineScreen() {
    Scaffold(
        topBar = {
            MineTitleBar()
        }
    ) {paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
        ) {

        }
    }
}

/**
 * 我的页预览函数
 */
@Preview
@Composable
private fun MineScreenPreview(): Unit {
    ListTheme {
        MineScreen()
    }
}