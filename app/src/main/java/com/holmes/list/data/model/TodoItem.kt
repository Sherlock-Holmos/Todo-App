package com.holmes.list.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,

    val title: String, // 待办的标题

    val description: String?, // 待办的详情

    val isCompleted: Boolean = false, // 待办是否完成

    val date: LocalDate? = null, // 待办的日期

    val time: LocalTime? = null // 待办的时间
)