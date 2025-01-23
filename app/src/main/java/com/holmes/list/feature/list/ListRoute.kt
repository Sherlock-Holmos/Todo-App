package com.holmes.list.feature.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.holmes.list.data.TestItems.TodoItems
import com.holmes.list.feature.list.component.ItemTodo
import com.holmes.list.ui.theme.ListTheme
import com.holmes.list.ui.theme.SpaceExtraOuterMedium
import com.holmes.list.ui.theme.SpaceMedium
import com.holmes.list.ui.theme.SpaceOuter

/**
 * 清单页路由
 */
@Composable
fun ListRoute() {
    ListScreen()
}

/**
 * 清单页函数
 */
@Composable
fun ListScreen(
    toggleDrawer: () -> Unit = {}, toSearch: () -> Unit = {}
) {
    Scaffold(topBar = {
        ListTopBar(
            toggleDrawer, toSearch
        )
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = SpaceOuter),
                verticalArrangement = Arrangement.spacedBy(SpaceExtraOuterMedium),
                modifier = Modifier.fillMaxSize(),
            ) {
                items(TodoItems){
                    ItemTodo(data = it)
                }
            }
        }
    }
}

/**
 * 清单界面顶部标题栏
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTopBar(toggleDrawer: () -> Unit, toSearch: () -> Unit) {
    CenterAlignedTopAppBar(navigationIcon = {
        IconButton(onClick = toggleDrawer) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    }, title = {
        Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .clickable {
                    toSearch()
                }) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(18.dp)
            )
            Text(
                text = "查询待办信息",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }, actions = {
        IconButton(onClick = toggleDrawer) {
            Icon(
                imageVector = Icons.Default.Settings,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    })
}

/**
 * 清单页预览函数
 */
@Preview(showBackground = true, widthDp = 330)
@Composable
private fun ListScreenPreview(): Unit {
    ListTheme {
        ListScreen()
    }
}