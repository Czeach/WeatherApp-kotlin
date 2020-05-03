package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.Current
import com.example.android.weatherapp.models.Daily
import com.example.android.weatherapp.models.Hourly
import com.example.android.weatherapp.models.WeatherData

//@Entity(tableName = "weather_data")
//data class DatabaseWeatherData constructor(
//    @PrimaryKey
//    val primaryKey: Int = 1,
//    @Embedded(prefix = "current_")
//    val current: Current? = null,
//    val daily: List<Daily>? = null,
//    val hourly: List<Hourly>? = null,
//    val lat: Double? = null,
//    val lon: Double? = null,
//    val timezone: String? = null
//)
//
//// this extension converts DatabaseWeatherData from a database object to a domain object
//fun List<DatabaseWeatherData>.asDomainModel(): List<WeatherData> {
//    return map {
//        WeatherData(
//            current = it.current,
//            daily = it.daily,
//            hourly = it.hourly,
//            lat = it.lat,
//            lon = it.lon,
//            timezone = it.timezone
//        )
//    }
//}