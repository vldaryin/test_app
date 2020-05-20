package com.example.android.features.lessons.domain

import com.example.android.data.model.lessons.Lesson
import com.example.android.data.repository.LessonRepository
import io.reactivex.Observable

class GetLessonsUseCase(private val repository: LessonRepository) {

    fun invoke(page: Int): Observable<List<Lesson>> {
        return repository.getLessonsWithCache(page)
    }
}