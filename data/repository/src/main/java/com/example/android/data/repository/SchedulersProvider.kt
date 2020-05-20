package com.example.android.data.repository

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulersProvider(
    val UI: Scheduler = AndroidSchedulers.mainThread(),
    val IO: Scheduler = Schedulers.io(),
    val SINGLE: Scheduler = Schedulers.single(),
    val COMPUTATION: Scheduler = Schedulers.computation()
)