package com.holmes.list.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holmes.list.data.model.TodoItem
import com.holmes.list.data.repository.TodoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * 待办页面的ViewModel
 */
class ListViewModel(private val repository: TodoRepository) : ViewModel() {

    // StateFlow 绑定到 UI
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos: StateFlow<List<TodoItem>> = _todos

    init {
        // 收集 Room 数据库中的数据
        viewModelScope.launch {
            repository.allTodos.collect { todoList ->
                _todos.value = todoList
            }
        }
    }

    // 处理用户交互的方法
    fun addTodo(todo: TodoItem) {
        viewModelScope.launch {
            repository.insert(todo)
        }
    }
}