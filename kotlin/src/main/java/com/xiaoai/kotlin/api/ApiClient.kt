package com.xiaoai.kotlin.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {
    fun <T> instanceRetrofit(apiInterface: Class<T>): T {
        val client = OkHttpClient().newBuilder().apply {
            readTimeout(10000, TimeUnit.SECONDS)
            connectTimeout(10000, TimeUnit.SECONDS)
            writeTimeout(10000, TimeUnit.SECONDS)
        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com")
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(apiInterface)
    }
}