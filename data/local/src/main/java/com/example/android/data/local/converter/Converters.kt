package com.example.android.data.local.converter

import androidx.room.TypeConverter
import com.example.android.data.model.lessons.LessonItem
import com.google.gson.Gson
import java.util.*

class Converters {

    private var gson = Gson()

    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun stringToLessonItem(value: String?): LessonItem? = objectFromString(value)

    @TypeConverter
    fun lessonItemToString(item: LessonItem?): String? = objectToString(item)

    private fun <T : Any> objectToString(anyObject: T?) = anyObject?.let { gson.toJson(it) }
    private inline fun <reified T : Any> objectFromString(data: String?) =
        data?.let { gson.fromJson(it, T::class.java) }

}