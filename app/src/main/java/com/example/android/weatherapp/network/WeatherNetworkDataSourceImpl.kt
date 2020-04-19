package com.example.android.weatherapp.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.weatherapp.domain.CurrentWeather
import com.example.android.weatherapp.internal.NoConnectionException

// this class is an implementation of the WeatherNetworkDataSource interface
class WeatherNetworkDataSourceImpl(
    private val openWeatherMapApiService: OpenWeatherMapApiService
) : WeatherNetworkDataSource {

    // create a variable that gets a MutableLiveData of CurrentWeather
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeather>()
    // cast the MutableLiveData gotten above to LiveData
    override val downloadedCurrentWeather: LiveData<CurrentWeather>
        get() = _downloadedCurrentWeather

    override suspend fun fetchCurrentWeather() {
        try {
            // fetch CurrentWeather from the api service
            val fetchedCurrentWeather = openWeatherMapApiService
                .getCurrentWeather()
                .await()
            // set downloadedCurrentWeather to fetchedCurrentWeather
            _downloadedCurrentWeather.postValue(fetchedCurrentWeather)
        } catch (e: NoConnectionException) {
            Log.e("Connection", "No internet connection", e)
        }
    }
}