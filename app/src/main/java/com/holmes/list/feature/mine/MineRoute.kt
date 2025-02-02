package com.holmes.list.feature.mine

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
    Text(text = "我的")
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