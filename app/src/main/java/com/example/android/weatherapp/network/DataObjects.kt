package com.example.android.weatherapp.network

import androidx.room.Embedded
import com.example.android.weatherapp.db.Clouds
import com.example.android.weatherapp.db.Coord
import com.example.android.weatherapp.db.CurrentWeather
import com.example.android.weatherapp.db.DatabaseCurrentWeather
import com.example.android.weatherapp.db.Main
import com.example.android.weatherapp.db.Sys
import com.example.android.weatherapp.db.Weather
import com.example.android.weatherapp.db.Wind


data class NetworkWeatherContainer(val weather: List<NetworkWeather>)


data class NetworkWeather(
    var base: String,
    @Embedded(prefix = "clouds_")
    var clouds: Clouds,
    var cod: Int,
    @Embedded(prefix = "coord_")
    var coord: Coord,
    var dt: Int,
    var id: Int,
    @Embedded(prefix = "main_")
    var main: Main,
    var name: String,
    @Embedded(prefix = "sys_")
    var sys: Sys,
    var timezone: Int,
    var visibility: Int,
    @Embedded(prefix = "weather_")
    var weather: List<Weather>,
    @Embedded(prefix = "wind_")
    var wind: Wind
)

fun NetworkWeatherContainer.asDomainModel(): List<CurrentWeather> {
    return weather.map {
        com.example.android.weatherapp.db.CurrentWeather(
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