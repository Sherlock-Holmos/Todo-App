package com.holmes.list.util

import android.annotation.SuppressLint
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class DateConverters {

    @SuppressLint("NewApi")
    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? {
        return date?.format(DateTimeFormatter.ISO_LOCAL_DATE)
    }

    @SuppressLint("NewApi")
    @TypeConverter
    fun toLocalDate(dateString: String?): LocalDate? {
        return dateString?.let {
            LocalDate.parse(it, DateTimeFormatter.ISO_LOCAL_DATE)
        }
    }

    @SuppressLint("NewApi")
    @TypeConverter
    fun fromLocalTime(time: LocalTime?): String? {
        return time?.format(DateTimeFormatter.ISO_LOCAL_TIME)
    }

    @SuppressLint("NewApi")
    @TypeConverter
    fun toLocalTime(timeString: String?): LocalTime? {
        return timeString?.let {
            LocalTime.parse(it, DateTimeFormatter.ISO_LOCAL_TIME)
        }
    }
}