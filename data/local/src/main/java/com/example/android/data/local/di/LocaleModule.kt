package com.example.android.data.local.di

import com.example.android.data.local.UULADatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

private const val DATABASE = "DATABASE"

val localModule = module {
    single(DATABASE) { UULADatabase.buildDatabase(androidContext()) }
    factory { (get(DATABASE) as UULADatabase).lessonDao() }
}