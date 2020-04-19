package com.example.android.weatherapp.network

import androidx.lifecycle.LiveData
import com.example.android.weatherapp.domain.CurrentWeather

interface WeatherNetworkDataSource {

    val downloadedCurrentWeather: LiveData<CurrentWeather>

    suspend fun fetchCurrentWeather()
}