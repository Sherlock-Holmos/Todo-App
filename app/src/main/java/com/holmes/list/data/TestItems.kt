package com.holmes.list.data

import com.holmes.list.data.model.TodoItem

object TestItems {
    val sTODO = TodoItem(
        id = 1,
        title = "Buy groceries",
        description = "Milk, Bread, Eggs",
        isCompleted = false
    )
    val TodoItems = listOf(
        sTODO,
        TodoItem(
            id = 2,
            title = "Walk the dog",
            description = "Take Max for a walk in the park",
            isCompleted = true
        ),
        TodoItem(
            id = 3,
            title = "Finish homework",
            description = "Math exercises and reading assignments",
            isCompleted = false
        ),
        TodoItem(
            id = 4,
            title = "Call Mom",
            description = null,
            isCompleted = false
        ),
        TodoItem(
            id = 5,
            title = "Prepare presentation",
            description = "Slides for the meeting on Friday",
            isCompleted = true
        )
    )
}