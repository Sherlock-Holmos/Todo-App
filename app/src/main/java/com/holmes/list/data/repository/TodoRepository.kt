package com.holmes.list.data.repository

import com.holmes.list.data.dao.TodoDao
import com.holmes.list.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {

    //获取所有数据
    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    //插入数据
    suspend fun insert(todo: TodoItem) {
        todoDao.insert(todo)
    }

    //删除数据
    suspend fun deleteById(id: Int) {
        todoDao.deleteById(id)
    }
}