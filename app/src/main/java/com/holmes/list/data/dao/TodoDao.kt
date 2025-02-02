package com.holmes.list.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.holmes.list.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: TodoItem)  // 插入数据

    @Update
    suspend fun update(todo: TodoItem)  // 更新数据

    @Query("SELECT * FROM todo_items ORDER BY id DESC")
    fun getAllTodos(): Flow<List<TodoItem>>  // 获取所有数据

    @Query("SELECT * FROM todo_items WHERE id = :id")
    suspend fun getById(id: Int): TodoItem?  // 根据 ID 查询数据

    @Query("DELETE FROM todo_items WHERE id = :id")
    suspend fun deleteById(id: Int)  // 根据 ID 删除数据
}