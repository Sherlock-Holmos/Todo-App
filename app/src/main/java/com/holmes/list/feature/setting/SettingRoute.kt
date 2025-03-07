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
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.settings_title))
                }
            )
        }
    ){paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Card {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    // 状态变量
                    var isDarkModeEnabled by remember { mutableStateOf(false) }
                    var notificationPreference by remember { mutableStateOf("Always") }
                    var username by remember { mutableStateOf("") }

                    // 滚动状态
                    val scrollState = rememberScrollState()

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
                }
            }
        }




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

@Preview(showBackground = true,widthDp = 320)
@Composable
fun PreviewSettingScreen() {
    SettingScreen()
}