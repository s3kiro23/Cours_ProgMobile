package com.example.rdvaflokkat

import kotlinx.coroutines.flow.Flow

class AdvisorRepository (){
    val getAdvisor: Flow<List<Advisor>> = AdvisorRemoteDataSource(AflokkatAPI2).advisors

//    suspend fun getAdvisor(aflokkatAPIService2: AflokkatAPIService2) : Flow<List<Advisor>>{
//        return  aflokkatAPIService2.getAdvisor()
//    }
}