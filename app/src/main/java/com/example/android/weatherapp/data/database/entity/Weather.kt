package com.example.android.weatherapp.data.database.entity

@Entity()
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)