package com.example.android.features.lessons.views

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.data.model.lessons.Lesson
import com.example.android.features.lessons.LessonsViewModel

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1
private const val ITEM_VIEW_TYPE_FOOTER = 2

class LessonsAdapter(private val viewModel: LessonsViewModel) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<DataItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_HEADER -> LessonsHeaderViewHolder.from(parent)
            ITEM_VIEW_TYPE_ITEM -> LessonsViewHolder.from(parent)
            ITEM_VIEW_TYPE_FOOTER -> LessonsFooterViewHolder.from(parent)
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LessonsHeaderViewHolder -> holder.bindTo(viewModel)
            is LessonsViewHolder -> {
                val lessonItem = items[position] as DataItem.LessonItem
                holder.bindTo(lessonItem.lesson, viewModel)
            }
            is LessonsFooterViewHolder -> holder.bindTo(viewModel)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.LessonItem -> ITEM_VIEW_TYPE_ITEM
            is DataItem.Footer -> ITEM_VIEW_TYPE_FOOTER
        }
    }

    override fun getItemCount() = items.size

    // ---

    fun updateData(list: List<Lesson>) {
        items.clear()
        items.add(DataItem.Header)
        items.addAll(list.map { DataItem.LessonItem(it) })
        items.add(DataItem.Footer)
        notifyDataSetChanged()
    }
}