package com.example.android.weatherapp.database.local

interface LocalWind {
    var windPrimaryKey: Int
    val degree: Int
    val speed: Double
}