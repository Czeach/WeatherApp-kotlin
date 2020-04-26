package com.example.android.weatherapp.models


import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

const val PRIMARY_KEY = 1

@Entity(tableName = "current_weather")
data class CurrentWeather(
    @PrimaryKey(autoGenerate = false)
    var primaryKey: Int = PRIMARY_KEY,
    val base: String,
    @Embedded(prefix = "clouds_")
    val clouds: Clouds?,
    val cod: Int,
    @Embedded(prefix = "coord_")
    val coord: Coord?,
    val dt: Int,
    val id: Int,
    @Embedded(prefix = "main_")
    val main: Main?,
    val name: String,
    @Embedded(prefix = "sys_")
    val sys: Sys?,
    val timezone: Int,
    val visibility: Int,
    @Embedded(prefix = "weather_")
    val weather: List<Weather>?,
    @Embedded(prefix = "wind_")
    val wind: Wind?
) {
    constructor() : this(0, "", null, 0, null, 0, 0,
        null, "", null,0,0,null, null)
}