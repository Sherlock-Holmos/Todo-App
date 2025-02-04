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
import androidx.compose.ui.text.style.TextOverflow
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
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                SpaceExtraSmall3Height()

                // 计算 deadline 字符串
                val deadline = if (data.date == null && data.time == null) {
                    "no deadline"
                } else {
                    buildString {
                        if (data.date != null) append(data.date.toString())
                        if (data.date != null && data.time != null) append(" ")
                        if (data.time != null) append(data.time.toString())
                    }
                }

                // 如果 deadline 不是 "no deadline"（即至少有一个日期或时间不是 null），则显示它
                if (deadline != "no deadline") {
                    Text(
                        text = deadline,
                        modifier = Modifier, // 可以根据需要添加修饰符
                        color = MaterialTheme.colorScheme.onSurface, // 文本颜色
                        style = MaterialTheme.typography.bodyMedium, // 文本样式
                    )
                }
                 else {
                     Text(
                         text = "no deadline",
                     )
                 }
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
