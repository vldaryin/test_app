package com.example.android.features.lessons.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.data.model.lessons.Lesson
import com.example.android.features.lessons.LessonsViewModel
import com.example.android.features.lessons.R
import com.example.android.features.lessons.databinding.ItemLessonBinding

class LessonsViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    companion object {
        fun from(parent: ViewGroup): LessonsViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_lesson, parent, false)
            return LessonsViewHolder(view)
        }
    }

    private val binding = ItemLessonBinding.bind(parent)

    fun bindTo(lesson: Lesson, viewModel: LessonsViewModel) {
        binding.lesson = lesson
        binding.viewModel = viewModel
    }
}