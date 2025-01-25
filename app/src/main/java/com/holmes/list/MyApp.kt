package com.holmes.list

import android.app.Application
import com.holmes.list.data.database.TodoDatabase
import com.holmes.list.data.database.TodoDatabaseInstance

class MyApp : Application() {
    lateinit var database: TodoDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        // 初始化数据库
        database = TodoDatabaseInstance.getDatabase(this)
    }
}