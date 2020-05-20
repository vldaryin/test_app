package com.example.android.features.lessons.di

import com.example.android.features.lessons.LessonsViewModel
import com.example.android.features.lessons.domain.GetLessonsUseCase
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val featureLessonsModule = module {
    factory { GetLessonsUseCase(get()) }
    viewModel { LessonsViewModel(get()) }
}