package com.example.android.weatherapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.domain.*

const val PRIMARY_KEY = 1

@Entity (tableName = "current_weather")
data class DatabaseCurrentWeather(
    // assign a primary key to the entity
    @PrimaryKey (autoGenerate = false)
    var primaryKey: Int = PRIMARY_KEY,

    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind)

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