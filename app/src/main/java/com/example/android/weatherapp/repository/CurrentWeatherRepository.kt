package com.example.android.weatherapp.repository

import com.example.android.weatherapp.db.CurrentWeatherDao
import com.example.android.weatherapp.models.CurrentWeather
import com.example.android.weatherapp.network.OpenWeatherMapApi
import retrofit2.Call

class CurrentWeatherRepository(private val currentWeatherDao: CurrentWeatherDao, private val openWeatherMapApi: OpenWeatherMapApi) {

    fun getWeather(): Call<CurrentWeather> {
        return openWeatherMapApi.getWeather()
    }

}