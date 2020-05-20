package com.example.android.data.model.lessons

import com.google.gson.annotations.SerializedName

data class LessonVideoImages(
    @SerializedName("xsmall") val xsmall: String,
    @SerializedName("small") val small: String,
    @SerializedName("medium") val medium: String,
    @SerializedName("large") val large: String,
    @SerializedName("xlarge") val xlarge: String,
    @SerializedName("xxlarge") val xxlarge: String)