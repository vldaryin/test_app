package com.example.android.uula.di

import com.example.android.data.local.di.localModule
import com.example.android.data.remote.di.createRemoteModule
import com.example.android.data.repository.di.repositoryModule
import com.example.android.features.lessons.di.featureLessonsModule

val appComponent= listOf(createRemoteModule("http://kw.uula-staging.com/"), repositoryModule, featureLessonsModule, localModule)