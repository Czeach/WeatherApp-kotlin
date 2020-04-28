package com.example.android.weatherapp.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.android.weatherapp.db.getDatabase
import com.example.android.weatherapp.repository.WeatherDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.io.IOException
import java.lang.IllegalArgumentException

class CurrentViewModel(application: Application): AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    // Event triggered for network error. This is private to avoid exposing a way to set this value to observers.
    private var _eventNetworkError = MutableLiveData<Boolean>(false)

    // Event triggered for network error. Views should use this to get access to the data.
    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError

    // Flag to display the error message. This is private to avoid exposing a way to set this value to observers.
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)

    // Flag to display the error message. Views should use this to get access to the data.
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    init {
        viewModelScope.launch {
//            weatherDataRepository.refreshCurrentData()
            refreshDataFromRepo()
        }
    }

    private val database = getDatabase(application)

    // ViewModel will fetch results from this data source
    private val weatherDataRepository = WeatherDataRepository(database)

    private val weatherDataList = weatherDataRepository.currentData

    private fun refreshDataFromRepo() {
        viewModelScope.launch {
            try {
                weatherDataRepository.refreshCurrentData()
                _eventNetworkError.value = false
                _isNetworkErrorShown.value = false
            } catch(networkError: IOException) {
                if(weatherDataList.value.isNullOrEmpty())
                    _eventNetworkError.value = true
            }
        }

    }

    class Factory(val app: Application): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CurrentViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CurrentViewModel(app) as T
            }
            return IllegalArgumentException("Unable to construct viewModel") as T
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
