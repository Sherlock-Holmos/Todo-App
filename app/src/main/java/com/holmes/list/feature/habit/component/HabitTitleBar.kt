package com.holmes.list.feature.habit.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

/**
 * 习惯页标题栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HabitTitleBar() {
    TopAppBar(title = { Text(text = "Habit", fontSize = 20.sp) }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Outlined.DateRange, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.List, contentDescription = null)
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null)
        }
    })
}

@Preview
@Composable
private fun HabitTitleBarPreview() {
    HabitTitleBar()
}