package com.holmes.list.feature.mine

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.holmes.list.feature.mine.component.MineTitleBar
import com.holmes.list.ui.theme.ListTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector



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
    Scaffold(topBar = {
        MineTitleBar()
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column {
                UserInfoDisplay()
                MenuList()
            }
        }
    }
}

/**
 * 用户信息显示函数
 */
@Composable
fun UserInfoDisplay() {
    Row(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = Icons.Filled.Person,
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 16.dp)
        )

        // 用户信息
        Column(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(
                text = "用户名"
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "邮箱"
            )
        }
    }
}

@Composable
fun MenuList() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp), // 圆角卡片
        elevation = CardDefaults.cardElevation(4.dp) // 增加阴影
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            MenuItem(icon = Icons.Filled.CheckCircle, title = "我的勋章") {
                // 这里可以添加点击逻辑，如跳转到“我的勋章”页面
            }
            Divider()
            MenuItem(icon = Icons.Filled.Menu, title = "待办周报") {
                // 这里可以添加点击逻辑，如跳转到“待办周报”页面
            }
            Divider()
            MenuItem(icon = Icons.Filled.DateRange, title = "四象限") {
                // 这里可以添加点击逻辑，如跳转到“四象限”页面
            }
            Divider()
            MenuItem(icon = Icons.Filled.Notifications, title = "番茄专注") {
                // 这里可以添加点击逻辑，如跳转到“番茄专注”页面
            }
        }
    }
}

/**
 * 单个菜单项
 */
@Composable
fun MenuItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick) // 点击事件
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = title, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp)) // 图标和文字之间的间距
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
    }
}


/**
 * 我的页预览函数
 */
@Preview
@Composable
private fun MineScreenPreview() {
    ListTheme {
        MineScreen()
    }
}