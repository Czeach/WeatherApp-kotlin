package com.example.android.weatherapp.models

import androidx.room.Embedded


data class WeatherData(
    val current: List<Current>?,
    val daily: List<Daily>?,
    val hourly: List<Hourly>?,
    val lat: Double?,
    val lon: Double?,
    val timezone: String?
)