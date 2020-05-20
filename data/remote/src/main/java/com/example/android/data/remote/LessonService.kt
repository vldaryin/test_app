package com.example.android.data.remote

import com.example.android.data.model.lessons.Lesson
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LessonService {

    @GET("/api/tests/lessons")
    fun getLessons(@Query("page") page: Int): Observable<List<Lesson>>
}