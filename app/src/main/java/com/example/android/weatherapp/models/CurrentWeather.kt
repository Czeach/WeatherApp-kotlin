package com.example.android.weatherapp.models


import androidx.room.Embedded

data class CurrentWeather(
    val base: String,
    @Embedded(prefix = "clouds_")
    val clouds: Clouds,
    val cod: Int,
    @Embedded(prefix = "coord_")
    val coord: Coord,
    val dt: Int,
    val id: Int,
    @Embedded(prefix = "main_")
    val main: Main,
    val name: String,
    @Embedded(prefix = "sys_")
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    @Embedded(prefix = "weather_")
    val weather: List<Weather>,
    @Embedded(prefix = "wind_")
    val wind: Wind
)