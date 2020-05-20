package com.example.android.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.android.data.model.lessons.Lesson
import io.reactivex.Flowable
import io.reactivex.Single
import java.util.*

@Dao
abstract class LessonDao : BaseDao<Lesson>() {

    @Query("SELECT * FROM Lesson WHERE page = :page")
    abstract fun getLessonsByPage(page: Int): Single<List<Lesson>>

    @Query("DELETE FROM Lesson WHERE page = :page")
    abstract fun deletePage(page: Int)

    // ---

    fun save(page: Int, lessons: List<Lesson>) {
        deletePage(page)
        insert(lessons.apply {
            forEach {
                it.lastRefreshed = Date()
                it.page = page
            }
        })
    }
}