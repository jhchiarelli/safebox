package br.com.unitysystem.safebox.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

fun cliente() =
    OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
fun gson(): Gson = GsonBuilder().create()

fun retrofit(): Retrofit =
    Retrofit.Builder()
        .baseUrl("")
        .client(cliente())
        .addConverterFactory(GsonConverterFactory.create(gson()))
        .build()

fun services() = retrofit().create(ApiService::class.java)