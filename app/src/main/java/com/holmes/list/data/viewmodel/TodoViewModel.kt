package com.holmes.list.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holmes.list.data.dao.TodoDao
import com.holmes.list.data.model.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TodoViewModel(private val todoDao: TodoDao) : ViewModel() {
    //待办列表
    val allTodos: Flow<List<TodoItem>> = todoDao.getAllTodos()

    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos: StateFlow<List<TodoItem>> = _todos

    /**
     * 插入待办事项
     */
    fun insertTodo(todo: TodoItem) {
        viewModelScope.launch {
            todoDao.insert(todo)
        }
    }

    /**
     * 更新待办事项
     */
    fun update(todo: TodoItem) {
        viewModelScope.launch {
            todoDao.update(todo)
        }
    }

    /**
     * 删除待办事项
     */
    fun deleteById(id: Int) {
        viewModelScope.launch {
            todoDao.deleteById(id)
        }
    }
}