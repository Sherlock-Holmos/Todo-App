package com.holmes.list.feature.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holmes.list.data.database.TodoDatabase
import com.holmes.list.data.model.TodoItem
import com.holmes.list.data.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * 待办页面的ViewModel
 */
class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: TodoRepository

    //待办列表
    val allTodos: Flow<List<TodoItem>> get() = repository.allTodos

    init {
        val todoDao = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
    }

    /**
     * 插入待办事项
     */
    fun insertTodo(todo: TodoItem) {
        viewModelScope.launch {
            repository.insert(todo)
        }
    }

    /**
     * 删除待办事项
     */
    fun deleteById(id: Int) {
        viewModelScope.launch {
            repository.deleteById(id)
        }
    }
}