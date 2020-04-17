package com.example.android.weatherapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val WEATHER_PRIMARY_KEY = 0

@Entity (tableName = "current_weather")
data class Weather(

    // assign a primary key to the entity
//    @PrimaryKey (autoGenerate = false)
//    var weatherPrimaryKey: Int = WEATHER_PRIMARY_KEY,

    val description: String,
    val icon: String,
    val id: Int,
    val main: String
) {
    // assign a primary key to the entity
    @PrimaryKey (autoGenerate = false)
    var weatherPrimaryKey: Int = WEATHER_PRIMARY_KEY
}