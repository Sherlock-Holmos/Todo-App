package com.holmes.list.feature.list

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.holmes.list.feature.list.component.AddTodoBottomSheet
import com.holmes.list.feature.list.component.ItemTodo
import com.holmes.list.feature.list.component.ListTopBar
import kotlinx.coroutines.launch

/**
 * 清单页路由
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListRoute() {
    val context = LocalContext.current
    val application = context.applicationContext as Application
    val listViewModel: ListViewModel = viewModel()
    ListScreen(viewModel = listViewModel)
}

/**
 * 清单页函数
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ListScreen(
    viewModel: ListViewModel
) {
    val toDoItems by viewModel.allTodos.collectAsState(initial = emptyList()) //待办事项列表
    var showBottomSheet by remember { mutableStateOf(false) } //是否显示底部弹窗
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed) //侧拉抽屉状态
    val scope = rememberCoroutineScope()

    /**
     * 侧拉抽屉
     */
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Spacer(Modifier.height(12.dp))
                    Text(
                        "More Options",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                    HorizontalDivider()

                    // 工具和资源
                    Text(
                        "Tools And Resources",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                    NavigationDrawerItem(label = { Text("Item 1") },
                        selected = false,
                        onClick = { /* Handle click */ })
                    NavigationDrawerItem(label = { Text("Item 2") },
                        selected = false,
                        onClick = { /* Handle click */ })

                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    // 设置和帮助
                    Text(
                        "Settings And Help",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.titleMedium
                    )
                    NavigationDrawerItem(label = { Text("Settings") },
                        selected = false,
                        icon = { Icon(Icons.Outlined.Settings, contentDescription = null) },
                        badge = { Text("20") }, // Placeholder
                        onClick = { /* Handle click */ })
                    NavigationDrawerItem(
                        label = { Text("Help and feedback") },
                        selected = false,
                        icon = { Icon(Icons.Default.Info, contentDescription = null) },
                        onClick = { /* Handle click */ },
                    )
                    Spacer(Modifier.height(12.dp))
                }
            }
        },
        drawerState = drawerState,
    ) {
        /**
         * 清单页主体
         */
        Scaffold(topBar = {
            ListTopBar(toggleDrawer = {
                scope.launch {
                    if (drawerState.isClosed) drawerState.open() else drawerState.close()
                }
            }, toSearch = {}, onSortByTime = {}, onSortByImportance = {})
        },
            // 添加悬浮按钮
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { showBottomSheet = true }, modifier = Modifier.padding(16.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add, contentDescription = null
                    )
                }
            }) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // 待办事项列表
                LazyColumn(
                    contentPadding = PaddingValues(horizontal = 25.dp),
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.fillMaxSize(),
                ) {
                    if (toDoItems.isEmpty()) {
                        item {
                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    "No To-Do Items", style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    } else {
                        items(toDoItems, key = { it.id }) { item ->
                            ItemTodo(data = item, onLongClick = { viewModel.deleteById(item.id) },
                                onUpdateCompletionStatus = { viewModel.updateTodoItemCompletionStatus(item.id) })
                        }
                    }
                }
            }

            // 添加待办事项底部弹窗
            if (showBottomSheet) {
                AddTodoBottomSheet(
                    showBottomSheet = showBottomSheet,
                    onDismiss = { showBottomSheet = false },
                    viewModel = viewModel
                )
            }
        }
    }
}