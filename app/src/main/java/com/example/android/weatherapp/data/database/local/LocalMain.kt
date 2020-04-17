package com.example.android.weatherapp.data.database.local

import com.google.gson.annotations.SerializedName

interface LocalMain {
    val feelsLike: Double
    val humidity: Int
    val pressure: Int
    val temperature: Double
    val temperatureMax: Double
    val temperatureMin: Double
}