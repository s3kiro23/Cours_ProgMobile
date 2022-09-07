package com.example.rdvaflokkat

import kotlinx.coroutines.flow.Flow

class AdvisorRepository (aflokkatAPIService2: AflokkatAPIService2){
    val getAdvisor: Flow<List<Advisor>> = aflokkatAPIService2.getAdvisor()

//    suspend fun getAdvisor(aflokkatAPIService2: AflokkatAPIService2) : Flow<List<Advisor>>{
//        return  aflokkatAPIService2.getAdvisor()
//    }
}