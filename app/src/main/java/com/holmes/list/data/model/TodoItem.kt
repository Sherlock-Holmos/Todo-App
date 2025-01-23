package com.holmes.list.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    /**
     * 待办的标题
     */
    val title: String,

    /**
     * 待办的详情
     */
    val description: String?,

    /**
     * 待办是否完成
     */
    val isCompleted: Boolean = false

)