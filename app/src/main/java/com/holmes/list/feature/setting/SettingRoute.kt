package com.holmes.list.feature.setting

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.holmes.list.R

@Composable
fun SettingRoute(): Unit {
    SettingScreen()
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingScreen() {
    // 状态变量
    var isDarkModeEnabled by remember { mutableStateOf(false) }
    var notificationPreference by remember { mutableStateOf("Always") }
    var username by remember { mutableStateOf("") }

    // 滚动状态
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // 标题
        Text(
            text = stringResource(id = R.string.settings_title),
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // 暗黑模式开关
        SettingItem(
            title = stringResource(id = R.string.dark_mode),
            description = stringResource(id = R.string.dark_mode_description)
        ) {
            Switch(
                checked = isDarkModeEnabled,
                onCheckedChange = { isDarkModeEnabled = it }
            )
        }

//        // 通知偏好设置
//        SettingItem(
//            title = stringResource(id = R.string.notification_preference),
//            description = stringResource(id = R.string.notification_preference_description)
//        ) {
//            val options = listOf("Always", "Only when open", "Never")
//            var expanded by remember { mutableStateOf(false) }
//
//            Box {
//                TextButton(onClick = { expanded = true }) {
//                    Text(text = notificationPreference)
//                }
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//                    options.forEach { option ->
//                        DropdownMenuItem(
//                            text = { Text(text = option) },
//                            onClick = {
//                                notificationPreference = option
//                                expanded = false
//                            }
//                        )
//                    }
//                }
//            }
//        }

//        // 用户名输入
//        SettingItem(
//            title = stringResource(id = R.string.username),
//            description = stringResource(id = R.string.username_description)
//        ) {
//            OutlinedTextField(
//                value = username,
//                onValueChange = { username = it },
//                label = { Text(text = stringResource(id = R.string.enter_username)) },
//                singleLine = true,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
//
//        // 保存按钮
//        Button(
//            onClick = {
//                // 处理保存逻辑
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 16.dp)
//        ) {
//            Text(text = stringResource(id = R.string.save_settings))
//        }
    }
}

@Composable
fun SettingItem(
    title: String,
    description: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )
        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(8.dp))
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSettingScreen() {
    SettingScreen()
}