package com.example.android.features.lessons.views

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.android.data.model.lessons.Lesson
import com.example.android.features.lessons.R

object LessonsBinding {

    @BindingAdapter("android:visibility")
    @JvmStatic
    fun setVisibility(view: View, value: Boolean?) {
        view.visibility = if (value == true) View.VISIBLE else View.GONE
    }

    @BindingAdapter("android:visibility")
    @JvmStatic
    fun setVisibility(view: View, value: String?) {
        view.visibility = if (value == "Video") View.VISIBLE else View.GONE
    }

    @BindingAdapter("app:items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, lessons: List<Lesson>?) {
        with(recyclerView.adapter as LessonsAdapter) {
            lessons?.let { updateData(it) }
        }
    }

    @BindingAdapter("app:background")
    @JvmStatic
    fun videoBackground(view: ImageView, lesson: Lesson?) {
        view.setBackgroundResource(0)
        view.setImageDrawable(null)
        when (lesson?.kind) {
            "Video" -> Glide
                .with(view.context)
                .load(lesson.item.images.large)
                .centerCrop()
                .transform(RoundedCorners(15))
                .into(view)
            "OfflineMaterial" -> view.setBackgroundResource(R.drawable.shape_bg_offline_material)
            "Survey" -> view.setBackgroundResource(R.drawable.shape_bg_survey)
        }
    }

    @BindingAdapter("app:additionalSrc")
    @JvmStatic
    fun setAdditionalImage(view: ImageView, kind: String?) {
        view.setImageResource(if (kind == "Video") R.drawable.ic_comments_24px else R.drawable.ic_insert_drive_file_24px_rounded)
    }

    @BindingAdapter("android:additionalText")
    @JvmStatic
    fun setAdditionalText(view: TextView, lesson: Lesson?) {
        view.text =
            if (lesson?.kind == "Video") "${lesson.item.commentsCount} Comments" else "${lesson?.item?.questionsCount} Pages"
    }

    @BindingAdapter("app:typeSrc")
    @JvmStatic
    fun setTypeImage(view: ImageView, kind: String?) {
        view.visibility = View.VISIBLE
        when (kind) {
            "OfflineMaterial" -> view.setImageResource(R.drawable.ic_offline_material_pdf)
            "Survey" -> view.setImageResource(R.drawable.ic_quiz)
            else -> view.visibility = View.GONE
        }
    }

    @BindingAdapter("android:typeText")
    @JvmStatic
    fun setTypeText(view: TextView, kind: String?) {
        view.visibility = View.VISIBLE
        when (kind) {
            "OfflineMaterial" -> view.text = view.context.getString(R.string.type_offline_material)
            "Survey" -> view.text = view.context.getString(R.string.type_survey)
            else -> view.visibility = View.GONE
        }
    }

    @BindingAdapter("app:videoDuration")
    @JvmStatic
    fun setVideoDurationText(view: TextView, lesson: Lesson?) {
        if (lesson?.kind == "Video") {
            val minutes = lesson.item.duration / 60
            val seconds = lesson.item.duration - minutes * 60
            view.text = String.format("$minutes:%02d", seconds)
            view.visibility = View.VISIBLE
        } else {
            view.visibility = View.GONE
        }
    }
}