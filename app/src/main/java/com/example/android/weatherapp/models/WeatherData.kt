package com.example.android.weatherapp.models

import androidx.room.Embedded


data class WeatherData(
    val current: Current? = null,
    val daily: List<Daily>? = null,
    val hourly: List<Hourly>? = null,
    val lat: Double? = null,
    val lon: Double? = null,
    val timezone: String? = null
)