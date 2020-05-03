package com.example.android.weatherapp.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.android.weatherapp.models.WeatherData
import com.example.android.weatherapp.network.Network
import com.example.android.weatherapp.network.OpenWeatherMapApi
import kotlinx.coroutines.*
import java.io.IOException
import java.lang.IllegalArgumentException

class CurrentViewModel(application: Application): AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    // Event triggered for network error. This is private to avoid exposing a way to set this value to observers.
//    private var _eventNetworkError = MutableLiveData<Boolean>(false)
//
//    // Event triggered for network error. Views should use this to get access to the data.
//    val eventNetworkError: LiveData<Boolean>
//        get() = _eventNetworkError
//
//    // Flag to display the error message. This is private to avoid exposing a way to set this value to observers.
//    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
//
//    // Flag to display the error message. Views should use this to get access to the data.
//    val isNetworkErrorShown: LiveData<Boolean>
//        get() = _isNetworkErrorShown

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    private val _weatherData = MutableLiveData<ArrayList<WeatherData>>()

    val weatherData: LiveData<ArrayList<WeatherData>>
        get() = _weatherData

//    init {
////        viewModelScope.launch {
////            weatherDataRepository.refreshWeatherData()
////            refreshDataFromRepo()
////        }
//        getWeatherData()
//    }
//
    private fun getWeatherData() {
        coroutineScope.launch {
            val weatherList = Network.data.getWeather()
            try {
                _weatherData.value = weatherList
            } catch (t: Throwable) {
                _response.value = "Failure: " + t.message
            }
        }
    }

//    private val database = getDatabase(application)

    // ViewModel will fetch results from this data source
//    private val weatherDataRepository = WeatherDataRepository(database)

//    private val weatherDataList = weatherDataRepository.currentData

//    private fun refreshDataFromRepo() {
//        viewModelScope.launch {
//            try {
//                weatherDataRepository.refreshWeatherData()
//                _eventNetworkError.value = false
//                _isNetworkErrorShown.value = false
//            } catch(networkError: IOException) {
//                if(weatherDataList.value.isNullOrEmpty())
//                    _eventNetworkError.value = true
//            }
//        }
//
//    }

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
