package com.example.rdvaflokkat

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.*

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
    suspend fun getConseillers(): List<String>
}

object AfflokatAPI {
    val retrofitService: AfflokatAPIService by lazy {
        retrofit.create(AfflokatAPIService::class.java)
    }
}

interface AflokkatAPIService2 {
    @GET("fe064751-1f68-4e6a-be28-85c8b8ad23d7")
     fun getAdvisor(): Flow<List<Advisor>>
}

object AflokkatAPI2 {
    val retrofitService2: AflokkatAPIService2 by lazy {
        retrofit.create(AflokkatAPIService2::class.java)
    }
}



