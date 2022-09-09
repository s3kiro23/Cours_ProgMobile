package com.example.aflokkatgarden

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class GardenRepository (private val gardenDao: GardenDao){
    val allPlant: Flow<List<Plant>> = gardenDao.getPlants()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(plant: Plant){
        gardenDao.insert(plant)
    }
}