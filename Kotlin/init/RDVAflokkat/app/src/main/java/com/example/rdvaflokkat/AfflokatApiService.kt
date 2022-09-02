package com.example.rdvaflokkat

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://mocki.io/v1/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface AfflokatAPIService {
    @GET("e1dddd34-a75c-41f5-9a17-82841fa690ce")
    suspend fun getConseillers() : List<String>
}

object AfflokatAPI {
    val retrofitService : AfflokatAPIService by lazy {
        retrofit.create(AfflokatAPIService::class.java)
    }
}
