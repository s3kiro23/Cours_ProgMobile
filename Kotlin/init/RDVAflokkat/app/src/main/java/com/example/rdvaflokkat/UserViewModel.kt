package com.example.rdvaflokkat

import androidx.lifecycle.*

class UserViewModel (private val repository: AdvisorRepository) : ViewModel() {
    val getAdvisor: LiveData<List<Advisor>> = repository.getAdvisor.asLiveData()
    val errorMessage = MutableLiveData<String>()
}

class UserViewModelFactory(private val repository: AdvisorRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UserViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}