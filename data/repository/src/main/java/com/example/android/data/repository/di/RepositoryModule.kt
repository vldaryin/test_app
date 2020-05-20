package com.example.android.data.repository.di

import com.example.android.data.repository.LessonRepository
import com.example.android.data.repository.LessonRepositoryImpl
import com.example.android.data.repository.SchedulersProvider
import org.koin.dsl.module.module

val repositoryModule = module {
    single { SchedulersProvider() }
    factory { LessonRepositoryImpl(get(), get(), get()) as LessonRepository }
}