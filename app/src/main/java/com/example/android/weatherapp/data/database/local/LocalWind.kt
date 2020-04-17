package com.example.android.weatherapp.data.database.local

interface LocalWind {
    var windPrimaryKey: Int
    val degree: Int
    val speed: Double
}