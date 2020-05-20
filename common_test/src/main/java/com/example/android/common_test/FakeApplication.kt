package com.example.android.common_test

import android.app.Application
import org.koin.android.ext.android.startKoin

class FakeApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf())
    }
}