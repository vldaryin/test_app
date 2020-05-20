package com.example.android.common_test.datasets

import com.example.android.data.model.lessons.Lesson
import com.example.android.data.model.lessons.LessonItem
import com.example.android.data.model.lessons.LessonVideoImages
import java.util.*

object LessonDataset {
    val FAKE_LESSONS = listOf(
        Lesson(
            0,
            "Video",
            LessonItem(
                false,
                4,
                "perferendis harum cumque 29",
                "Accusantium laboriosam repellendus debitis non. Totam explicabo impedit. Atque enim quo pariatur harum et ipsam beatae.",
                LessonVideoImages(
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg"
                ),
                "Explicabo cumque dolorum distinctio.",
                200,
                0,
                0,
                "",
                ""
            ),
            Date(),
            1
        ),
        Lesson(
            1,
            "Survey",
            LessonItem(
                true,
                9,
                "Maiores quis molestias voluptatem.",
                "Accusantium laboriosam repellendus debitis non. Totam explicabo impedit. Atque enim quo pariatur harum et ipsam beatae.",
                LessonVideoImages(
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg"
                ),
                "Molestias velit sunt et.",
                200,
                0,
                0,
                "",
                ""
            ),
            Date(),
            1
        ),
        Lesson(
            2,
            "OfflineMaterial",
            LessonItem(
                true,
                9,
                "eveniet soluta excepturi 57",
                "Accusantium laboriosam repellendus debitis non. Totam explicabo impedit. Atque enim quo pariatur harum et ipsam beatae.",
                LessonVideoImages(
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg",
                    "https://i.vimeocdn.com/video/812774707_960x540.jpg"
                ),
                "Quod sint aut nobis.",
                200,
                0,
                0,
                "pdf",
                "pdf"
            ),
            Date(),
            1
        )
    )
}