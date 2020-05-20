package com.example.android.features.lessons

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.android.common.base.BaseViewModel
import com.example.android.common.utils.Event
import com.example.android.data.model.lessons.Lesson
import com.example.android.features.lessons.domain.GetLessonsUseCase
import io.reactivex.rxkotlin.plusAssign

class LessonsViewModel(private val getLessonsUseCase: GetLessonsUseCase) : BaseViewModel() {

    private val MIN_LESSON_PAGE = 1
    private val MAX_LESSON_PAGE = 10

    private val _lessons = MediatorLiveData<List<Lesson>>()
    val lessons: LiveData<List<Lesson>> get() = _lessons

    private val _lessonsProgress = MutableLiveData<String>()
    val lessonsProgress: LiveData<String> get() = _lessonsProgress

    private val _currentPage = MutableLiveData<Int>()

    private val _nextPageEnabled = MutableLiveData<Boolean>()
    val nextPageEnabled: LiveData<Boolean> get() = _nextPageEnabled

    private val _previousPageEnabled = MutableLiveData<Boolean>()
    val previousPageEnabled: LiveData<Boolean> get() = _previousPageEnabled

    init {
        _currentPage.value = MIN_LESSON_PAGE
        getLessons()
    }

    fun onNextPageButtonClicked() {
        _currentPage.value = _currentPage.value?.plus(1)
        getLessons()
    }

    fun onPreviousButtonClicked() {
        _currentPage.value = _currentPage.value?.minus(1)
        getLessons()
    }

    private fun getLessons() {
        disposables += getLessonsUseCase.invoke(_currentPage.value ?: MIN_LESSON_PAGE)
            .doOnSubscribe { _ ->
                _loaderProgressBar.value = Event(true)
            }.doOnTerminate {
                _loaderProgressBar.value = Event(false)
            }
            .subscribe({
                _lessons.value = it
                _lessonsProgress.value = getLessonsProgress(it)
                setFooterButtons()
            }, { throwable ->
                _snackbarError.value = Event(throwable.message ?: "error")
            })
    }

    private fun getLessonsProgress(lessons: List<Lesson>): String {
        val visitedLessons = lessons.filter { it.item.visited }
        return String.format("${visitedLessons.size}/${lessons.size}")
    }

    private fun setFooterButtons() {
        _nextPageEnabled.value = _currentPage.value ?: MIN_LESSON_PAGE < MAX_LESSON_PAGE
        _previousPageEnabled.value = _currentPage.value ?: MIN_LESSON_PAGE > MIN_LESSON_PAGE
    }
}