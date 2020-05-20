package com.example.android.data.repository

import com.example.android.data.local.dao.LessonDao
import com.example.android.data.model.lessons.Lesson
import com.example.android.data.remote.LessonDataSource
import io.reactivex.Observable

interface LessonRepository {

    fun getLessonsWithCache(page: Int): Observable<List<Lesson>>
}

class LessonRepositoryImpl(
    private val dataSource: LessonDataSource,
    private val dao: LessonDao,
    private val schedulersProvider: SchedulersProvider
) : LessonRepository {

    override fun getLessonsWithCache(page: Int): Observable<List<Lesson>> {
        return Observable.concat(getCachedLessons(page), fetchLessons(page))
            .observeOn(schedulersProvider.UI)
    }

    private fun getCachedLessons(page: Int): Observable<List<Lesson>> {
        return dao.getLessonsByPage(page).subscribeOn(schedulersProvider.SINGLE).toObservable()
    }

    private fun fetchLessons(page: Int): Observable<List<Lesson>> =
        dataSource.fetchLessonServiceAsync(page)
            .flatMap {
                dao.save(page, it)
                getCachedLessons(page)
            }
            .subscribeOn(schedulersProvider.IO)

}