package com.holmes.list.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.holmes.list.data.model.TodoItem

@Dao
interface TodoDao {
    @Insert
    suspend fun insert(todo: TodoItem)

    @Update
    suspend fun update(todo: TodoItem)

    @Query("SELECT * FROM todo_items")
    suspend fun getAll(): List<TodoItem>

    @Query("SELECT * FROM todo_items WHERE id = :id")
    suspend fun getById(id: Int): TodoItem?

    @Query("DELETE FROM todo_items WHERE id = :id")
    suspend fun deleteById(id: Int)
}