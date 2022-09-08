package com.example.rdvaflokkat

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AdvisorRemoteDataSource(
    private val aflokkatAPIService2: AflokkatAPI2,
    private val refreshIntervalMs: Long = 5000
) {
    val advisors: Flow<List<Advisor>> = flow {
        while (true) {
            val advisors = aflokkatAPIService2.retrofitService2.getAdvisor()
            emit(advisors)
            delay(refreshIntervalMs)
        }
    }
}