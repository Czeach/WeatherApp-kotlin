package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.Current
import com.example.android.weatherapp.models.Daily
import com.example.android.weatherapp.models.Hourly
import com.example.android.weatherapp.models.WeatherData

@Entity(tableName = "weather_data")
data class DatabaseWeatherData constructor(
    @PrimaryKey
    val primaryKey: Int = 1,
    val current: List<Current>,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val timezone: String
)

fun List<DatabaseWeatherData>.asDomainModel(): List<WeatherData> {
    return map {
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