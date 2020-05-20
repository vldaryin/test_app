package com.example.android.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.android.data.local.converter.Converters
import com.example.android.data.local.dao.LessonDao
import com.example.android.data.model.lessons.Lesson

@Database(entities = [Lesson::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class UULADatabase : RoomDatabase() {

    // DAO
    abstract fun lessonDao(): LessonDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, UULADatabase::class.java, "UULA.db")
                .build()
    }
}