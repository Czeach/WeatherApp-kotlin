package com.example.android.weatherapp.models


import androidx.room.Embedded
import androidx.room.PrimaryKey


const val PRIMARY_KEY = 1

data class CurrentWeather(
    @PrimaryKey(autoGenerate = false)
    var primaryKey: Int = PRIMARY_KEY,
    var base: String? = null,
    @Embedded(prefix = "clouds_")
    var clouds: Clouds? = null,
    var cod: Int? = null,
    @Embedded(prefix = "coord_")
    var coord: Coord? = null,
    var dt: Int? = null,
    var id: Int? = null,
    @Embedded(prefix = "main_")
    var main: Main? = null,
    var name: String? = null,
    @Embedded(prefix = "sys_")
    var sys: Sys? = null,
    var timezone: Int? = null,
    var visibility: Int? = null,
    @Embedded(prefix = "weather_")
    var weather: List<Weather>? = null,
    @Embedded(prefix = "wind_")
    var wind: Wind? = null
)