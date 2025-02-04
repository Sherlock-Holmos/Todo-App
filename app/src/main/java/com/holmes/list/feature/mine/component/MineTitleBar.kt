package com.holmes.list.feature.mine.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

/**
 * 我的页标题栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MineTitleBar() {
    CenterAlignedTopAppBar(title = { Text(text = "Mine", fontSize = 20.sp) }
    )
}