package com.example.android.weatherapp.data.database.local

interface LocalSys {
    var sysPrimaryKey: Int
    val country: String
    val sunrise: Int
    val sunset: Int
}