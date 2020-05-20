package com.example.android.features.lessons.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.features.lessons.LessonsViewModel
import com.example.android.features.lessons.R
import com.example.android.features.lessons.databinding.ItemLessonHeaderBinding

class LessonsHeaderViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    companion object {
        fun from(parent: ViewGroup): LessonsHeaderViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_lesson_header, parent, false)
            return LessonsHeaderViewHolder(view)
        }
    }

    private val binding = ItemLessonHeaderBinding.bind(parent)

    fun bindTo(viewModel: LessonsViewModel) {
        binding.viewModel = viewModel
    }
}