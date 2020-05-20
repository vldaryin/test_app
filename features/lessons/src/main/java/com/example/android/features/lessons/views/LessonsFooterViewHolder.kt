package com.example.android.features.lessons.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.features.lessons.LessonsViewModel
import com.example.android.features.lessons.R
import com.example.android.features.lessons.databinding.ItemLessonFooterBinding

class LessonsFooterViewHolder(parent: View) : RecyclerView.ViewHolder(parent) {

    companion object {
        fun from(parent: ViewGroup): LessonsFooterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val view = layoutInflater.inflate(R.layout.item_lesson_footer, parent, false)
            return LessonsFooterViewHolder(view)
        }
    }

    private val binding = ItemLessonFooterBinding.bind(parent)

    fun bindTo(viewModel: LessonsViewModel) {
        binding.viewModel = viewModel
    }
}