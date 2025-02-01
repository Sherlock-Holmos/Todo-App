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

    fun insertTodo(todo: TodoItem) {
        viewModelScope.launch {
            todoDao.insert(todo)
        }
    }

    fun update(todo: TodoItem) {
        viewModelScope.launch {
            todoDao.update(todo)
        }
    }

    fun deleteById(id: Int) {
        viewModelScope.launch {
            todoDao.deleteById(id)
        }
    }
}