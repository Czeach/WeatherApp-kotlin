package com.example.android.weatherapp.database.local

interface LocalMain {
    var mainPrimaryKey: Int
    val feelsLike: Double
    val humidity: Int
    val pressure: Int
    val temperature: Double
    val temperatureMax: Double
    val temperatureMin: Double
}