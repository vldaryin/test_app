package com.example.android.data.remote

import com.example.android.data.model.lessons.Lesson
import io.reactivex.Observable
import io.reactivex.ObservableTransformer

class LessonDataSource(private val service: LessonService) {

    fun fetchLessonServiceAsync(page: Int): Observable<List<Lesson>> =
        service.getLessons(page).compose(handleResponseOrThrow { response -> response })

    private inline fun <T : List<Lesson>, R> handleResponseOrThrow(crossinline convert: (T) -> R): ObservableTransformer<T, R> {
        return ObservableTransformer {
            it.map { response ->
                //if (response.error == null) {
                    convert(response)
                /*} else {
                    throw ApiException.message(response.message)
                }*/
            }
        }
    }
}