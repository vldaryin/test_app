package com.example.android.features.lessons.views

import com.example.android.data.model.lessons.Lesson

sealed class DataItem {

    data class LessonItem(val lesson: Lesson) : DataItem() {
        override val id: Long = lesson.id.toLong()
    }

    object Header : DataItem() {
        override val id = Long.MIN_VALUE
    }

    object Footer : DataItem() {
        override val id = Long.MAX_VALUE
    }

    abstract val id: Long
}