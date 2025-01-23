package com.holmes.list.feature.week

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.holmes.list.R
import com.holmes.list.ui.theme.ListTheme
import com.holmes.list.util.SuperDateUtil

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