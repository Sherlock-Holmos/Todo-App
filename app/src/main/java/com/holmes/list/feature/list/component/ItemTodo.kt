package com.holmes.list.feature.list.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.holmes.list.data.TestItems.sTODO
import com.holmes.list.data.model.TodoItem
import com.holmes.list.ui.theme.ListTheme
import com.holmes.list.ui.theme.Space3XLarge
import com.holmes.list.ui.theme.SpaceExtramSmall3Height
import com.holmes.list.ui.theme.SpaceMedium
import com.holmes.list.ui.theme.SpaceSmall

@Composable
fun ItemTodo(data: TodoItem, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = Space3XLarge)
                .padding(vertical = SpaceSmall)
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.primary,
            )
            SpaceExtramSmall3Height()

            Text(
                text = if (data.isCompleted) "已完成" else "未完成"
            )
        }
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = null,
            tint = if (data.isCompleted) MaterialTheme.colorScheme.surface else MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .padding(horizontal = Space3XLarge)
                .padding(vertical = SpaceSmall)
        )
    }
}


@Preview(showBackground = true, widthDp = 330)
@Composable
fun ItemTodoPreview() {
    ListTheme {
        ItemTodo(
            data = sTODO
        )
    }
}