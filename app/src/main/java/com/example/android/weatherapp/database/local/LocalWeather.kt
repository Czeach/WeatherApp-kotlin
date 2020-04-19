package com.example.android.weatherapp.database.local

interface LocalWeather {
    var weatherPrimaryKey: Int
    val description: String
    val icon: String
    val id: Int
    val main: String
}