package com.example.android.weatherapp.data.database.local

interface LocalWeather {
    val description: String
    val icon: String
    val id: Int
    val main: String
}