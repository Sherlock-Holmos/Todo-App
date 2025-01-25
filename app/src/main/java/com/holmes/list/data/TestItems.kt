package com.holmes.list.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.holmes.list.data.TestItems.TodoItems
import com.holmes.list.data.model.TodoItem
import java.time.LocalDateTime

/**
 * 测试数据提供者
 */
class TestItemsProvider:PreviewParameterProvider<List<TodoItem>>{
    @RequiresApi(Build.VERSION_CODES.O)
    override val values: Sequence<List<TodoItem>> = sequenceOf(TodoItems)
}

/**
 * 测试用例
 */
object TestItems {
    @RequiresApi(Build.VERSION_CODES.O)
    val sTODO = TodoItem(
        id = 1,
        title = "Buy groceries",
        description = "Milk, Bread, Eggs",
        isCompleted = false,
        deadline = LocalDateTime.of(2023, 1, 31, 17, 0) // 设置截止日期和时间
    )

    @RequiresApi(Build.VERSION_CODES.O)
    val TodoItems = listOf(
        sTODO,
        TodoItem(
            id = 2,
            title = "Walk the dog",
            description = "Take Max for a walk in the park",
            isCompleted = true,
            deadline = LocalDateTime.of(2023, 1, 25, 9, 0) // 示例截止日期和时间
        ),
        TodoItem(
            id = 3,
            title = "Finish homework",
            description = "Math exercises and reading assignments",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 2, 5, 18, 30) // 示例截止日期和时间
        ),
        TodoItem(
            id = 4,
            title = "Call Mom",
            description = null,
            isCompleted = false,
            deadline = null // 没有截止日期
        ),
        TodoItem(
            id = 5,
            title = "Prepare presentation",
            description = "Slides for the meeting on Friday",
            isCompleted = true,
            deadline = LocalDateTime.of(2023, 1, 28, 14, 0) // 示例截止日期和时间
        ),
        // 新增的待办事项
        TodoItem(
            id = 6,
            title = "Book flight tickets",
            description = "For the trip to New York next month",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 2, 10, 12, 0) // 示例截止日期和时间
        ),
        TodoItem(
            id = 7,
            title = "Visit the dentist",
            description = "Routine check-up appointment",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 2, 15, 10, 0) // 示例截止日期和时间
        ),
        TodoItem(
            id = 8,
            title = "Read a book",
            description = "Finish 'The Great Gatsby'",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 2, 20, 20, 0) // 示例截止日期和时间
        ),
        TodoItem(
            id = 9,
            title = "Grocery shopping",
            description = "Buy ingredients for the recipe",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 1, 30, 18, 0) // 示例截止日期和时间
        ),
        TodoItem(
            id = 10,
            title = "Plan weekend getaway",
            description = "Research destinations and accommodations",
            isCompleted = false,
            deadline = LocalDateTime.of(2023, 2, 25, 9, 0) // 示例截止日期和时间
        )
    )
}