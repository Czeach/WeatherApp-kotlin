package com.example.android.weatherapp.network

import com.example.android.weatherapp.models.Current
import com.example.android.weatherapp.models.Daily
import com.example.android.weatherapp.models.Hourly
import com.example.android.weatherapp.models.WeatherData

//data class NetworkWeatherDataContainer(
//    val currentData: List<NetworkWeatherData>
//)
//
//data class NetworkWeatherData(
//    val primaryKey: Int = 1,
//    val current: Current? = null,
//    val daily: List<Daily>? = null,
//    val hourly: List<Hourly>? = null,
//    val lat: Double? = null,
//    val lon: Double? = null,
//    val timezone: String? = null
//)
//
//fun NetworkWeatherDataContainer.asDomainModel(): List<WeatherData> {
//        return currentData.map {
//            WeatherData(
//                current = it.current,
//                daily = it.daily,
//                hourly = it.hourly,
//                lat = it.lat,
//                lon = it.lon,
//                timezone = it.timezone
//            )
//        }
//}
//
//// this extension converts NetworkWeatherDataContainer from a data transfer object to a database object
//fun NetworkWeatherDataContainer.asDatabaseModel(): Array<DatabaseWeatherData> {
//        return currentData.map {
//            DatabaseWeatherData(
//                primaryKey = it.primaryKey,
//                current = it.current,
//                daily = it.daily,
//                hourly = it.hourly,
//                lat = it.lat,
//                lon = it.lon,
//                timezone = it.timezone
//            )
//        }.toTypedArray()
//}