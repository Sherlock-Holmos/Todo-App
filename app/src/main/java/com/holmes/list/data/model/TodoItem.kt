package com.holmes.list.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val title: String, // 待办的标题

    val description: String?, // 待办的详情

    val isCompleted: Boolean = false, // 待办是否完成

    val deadline: LocalDateTime? = null // 待办的截止时间
)