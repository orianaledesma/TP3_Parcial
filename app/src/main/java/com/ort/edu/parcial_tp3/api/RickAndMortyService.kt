package com.ort.edu.parcial_tp3.api

import com.ort.edu.parcial_tp3.`interface`.RickAndMortyAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RickAndMortyService {
    companion object {
        fun create(baseUrl: String): RickAndMortyAPI {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RickAndMortyAPI::class.java)
        }

    }
}