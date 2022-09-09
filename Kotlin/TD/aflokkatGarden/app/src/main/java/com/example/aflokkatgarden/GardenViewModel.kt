package com.example.aflokkatgarden

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class GardenViewModel(private val repository: GardenRepository) : ViewModel() {
    val allPlant: LiveData<List<Plant>> = repository.allPlant.asLiveData()

    fun insert(plant: Plant) = viewModelScope.launch {
        repository.insert(plant)
    }
}

//class GardenViewModelFactory(private val repository: GardenRepository) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(GardenViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return GardenViewModel(repository) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}