package com.example.android.data.model.lessons

import com.google.gson.annotations.SerializedName

data class LessonItem(
    @SerializedName("visited") val visited: Boolean,
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("images") val images: LessonVideoImages,
    @SerializedName("about") val about: String,
    @SerializedName("duration") val duration: Int,
    @SerializedName("comments_count") val commentsCount: Int,
    @SerializedName("questions_count") val questionsCount: Int,
    @SerializedName("format") val format: String,
    @SerializedName("file_extension") val fileExtension: String
) {
}