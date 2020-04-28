package com.example.android.weatherapp.network

import com.example.android.weatherapp.db.DatabaseWeatherData
import com.example.android.weatherapp.models.Current
import com.example.android.weatherapp.models.Daily
import com.example.android.weatherapp.models.Hourly
import com.example.android.weatherapp.models.WeatherData

data class NetworkWeatherDataContainer(
    val currentData: List<NetworkWeatherData>?
)

data class NetworkWeatherData(
    val primaryKey: Int = 1,
    val current: List<Current>?,
    val daily: List<Daily>?,
    val hourly: List<Hourly>?,
    val lat: Double?,
    val lon: Double?,
    val timezone: String?
)

fun NetworkWeatherDataContainer.asDomainModel(): List<WeatherData> {
    return currentData!!.map {
        WeatherData(
            current = it.current,
            daily = it.daily,
            hourly = it.hourly,
            lat = it.lat,
            lon = it.lon,
            timezone = it.timezone
        )
    }
}

fun NetworkWeatherDataContainer.asDatabaseModel(): Array<DatabaseWeatherData?> {
    return currentData!!.map {
        DatabaseWeatherData(
            primaryKey = it.primaryKey,
            current = it.current,
            daily = it.daily,
            hourly = it.hourly,
            lat = it.lat,
            lon = it.lon,
            timezone = it.timezone
        )
    }.toTypedArray()
}