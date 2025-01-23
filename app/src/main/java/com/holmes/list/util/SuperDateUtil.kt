package com.holmes.list.util

import android.icu.util.Calendar
import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object SuperDateUtil {
    /**
     * 获取当前年份
     */
    fun CurrentYear():Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    /**
     * 时间转String工具
     */
    @RequiresApi(Build.VERSION_CODES.O)
    fun formatLocalDateTime(dateTime: LocalDateTime?): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        return dateTime?.format(formatter) ?: "No deadline"
    }
}