package com.example.android.data.remote.di

import com.example.android.data.remote.LessonDataSource
import com.example.android.data.remote.LessonService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String) = module {

    factory<HttpLoggingInterceptor> { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }

    factory("Interceptor") {
        Interceptor { chain ->
            val originalRequest = chain.request()

            val request = originalRequest
                .newBuilder()
                .addHeader("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MTA4LCJleH")
                .build()

            val responseBuilder = chain.proceed(request).newBuilder()
            responseBuilder.build()
        }
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(get<HttpLoggingInterceptor>())
            .addInterceptor(get<Interceptor>("Interceptor"))
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory { get<Retrofit>().create(LessonService::class.java) }

    factory { LessonDataSource(get()) }
}