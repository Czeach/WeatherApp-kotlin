package com.example.android.weatherapp.network

import androidx.room.Embedded
import com.example.android.weatherapp.db.DatabaseCurrentWeather
import com.example.android.weatherapp.models.*
import com.google.gson.annotations.JsonAdapter


data class NetworkWeatherContainer(val weather: List<NetworkWeather>)


data class NetworkWeather(
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

fun NetworkWeatherContainer.asDomainModel(): List<CurrentWeather> {
    return weather.map {
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

fun NetworkWeatherContainer.asDatabaseModel(): Array<DatabaseCurrentWeather> {
    return weather.map {
        DatabaseCurrentWeather(
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
    }.toTypedArray()
}