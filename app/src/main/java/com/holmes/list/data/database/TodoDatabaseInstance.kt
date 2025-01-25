package com.holmes.list.data.database

import android.content.Context
import androidx.room.Room

object TodoDatabaseInstance {

    @Volatile
    private var INSTANCE: TodoDatabase? = null

    // 获取数据库实例
    fun getDatabase(context: Context): TodoDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext, // 防止内存泄漏
                TodoDatabase::class.java,   // 指定数据库类
                "todo_database"            // 数据库名称
            ).build()
            INSTANCE = instance
            instance
        }
    }
}