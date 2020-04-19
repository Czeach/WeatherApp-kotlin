package com.example.android.weatherapp.data.response.network

import androidx.lifecycle.LiveData

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>

    suspend fun fetchCurrentWeather()
}