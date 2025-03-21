package com.holmes.list.util

import android.annotation.SuppressLint
import android.icu.util.Calendar
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object SuperDateUtil {
    /**
     * 获取当前年份
     */
    fun currentYear():Int {
        return Calendar.getInstance().get(Calendar.YEAR)
    }

    /**
     * 时间转String工具(年月日)
     */
    @SuppressLint("NewApi")
    fun formatLocalDateTimeYearMonthDay(dateTime: LocalDate?): String {
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return dateTime?.format(formatter) ?: "No deadline"
    }


    /**
     * 时间戳转化为LocalDate
     */
    @SuppressLint("NewApi")
    fun timestampToLocalDate(timestamp: Long?): LocalDate {
        return Instant.ofEpochMilli(timestamp?:0)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
    }
}