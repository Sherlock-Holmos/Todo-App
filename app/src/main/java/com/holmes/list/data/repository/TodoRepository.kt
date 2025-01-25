package com.holmes.list.data.repository

import com.holmes.list.data.dao.TodoDao
import com.holmes.list.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    //插入数据
    suspend fun insert(todo: TodoItem) {
        todoDao.insert(todo)
    }

    //删除数据
    suspend fun update(todo: TodoItem) {
        todoDao.update(todo)
    }
}