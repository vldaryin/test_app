package com.example.android.data.model.lessons

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*
import java.util.concurrent.TimeUnit

@Entity
data class Lesson(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @SerializedName("kind") val kind: String,
    @SerializedName("item") val item: LessonItem,
    var lastRefreshed: Date,
    var page: Int
) {

    fun haveToRefreshFromNetwork(): Boolean =
        TimeUnit.MILLISECONDS.toMinutes(Date().time - lastRefreshed.time) >= 10
}