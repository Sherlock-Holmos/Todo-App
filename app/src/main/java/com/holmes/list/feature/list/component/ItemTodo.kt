package com.holmes.list.feature.list.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.holmes.list.data.model.TodoItem
import com.holmes.list.ui.theme.ShapeLarge
import com.holmes.list.ui.theme.Space3XLarge
import com.holmes.list.ui.theme.SpaceExtraSmall3Height
import com.holmes.list.ui.theme.SpaceSmall
import com.holmes.list.util.SuperDateUtil.formatLocalDateTimeYearMonthDay

/**
 * 待办事项条目
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ItemTodo(
    data: TodoItem,
    onLongClick: () -> Unit,
    onUpdateCompletionStatus: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    // 待办事项卡片
    Card(
        modifier = Modifier.pointerInput(Unit) { detectTapGestures(onLongPress = { onLongClick() }) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        // 待办事项内容
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .clip(ShapeLarge)
                .background(MaterialTheme.colorScheme.surfaceVariant)
                .height(70.dp)
        ) {
            // 待办事项标题和截止日期
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = Space3XLarge)
            ) {
                Text(
                    text = data.title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                )

                SpaceExtraSmall3Height()

                // 截止日期
                val formattedDeadline = formatLocalDateTimeYearMonthDay(data.date)
                Text(
                    text = formattedDeadline,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }

            // 待办事项完成状态
            Checkbox(
                checked = data.isCompleted,
                onCheckedChange = { onUpdateCompletionStatus(data.id) },
                modifier = Modifier
                    .padding(horizontal = Space3XLarge)
                    .padding(vertical = SpaceSmall)
                    .size(32.dp)
            )
        }
    }
}
