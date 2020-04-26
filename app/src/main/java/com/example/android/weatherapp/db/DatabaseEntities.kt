package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.*

@Entity(tableName = "current_weather")
data class DatabaseCurrentWeather constructor(
    @PrimaryKey(autoGenerate = false)
    var primaryKey: Int = PRIMARY_KEY,
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

fun List<DatabaseCurrentWeather>.asDomainModel(): List<CurrentWeather> {
    return map {
        CurrentWeather(
            base = it.base,
            clouds = it.clouds,
            cod = it.cod,
            coord = it.coord,
            dt = it.dt,
            id = it.id,
            main = it.main,
            name = it.name,
            sys = it.sys,
            timezone = it.timezone,
            visibility = it.visibility,
            weather = it.weather,
            wind = it.wind
        )
    }
}