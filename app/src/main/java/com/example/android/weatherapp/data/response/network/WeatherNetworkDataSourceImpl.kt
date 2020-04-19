package com.example.android.weatherapp.data.response.network

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.weatherapp.internal.NoConnectionException
import kotlinx.android.synthetic.main.current_fragment.*

// this class is an implementation of the WeatherNetworkDataSource interface
class WeatherNetworkDataSourceImpl(
    private val openWeatherMapApiService: OpenWeatherMapApiService
) : WeatherNetworkDataSource {

    // create a variable that gets a MutableLiveData of CurrentWeatherResponse
    private val _downloadedCurrentWeather = MutableLiveData<CurrentWeatherResponse>()
    // cast the MutableLiveData gotten above to LiveData
    override val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
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