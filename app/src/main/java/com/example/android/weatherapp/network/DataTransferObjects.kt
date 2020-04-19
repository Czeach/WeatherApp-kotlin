package com.example.android.weatherapp.network

import com.example.android.weatherapp.database.DatabaseCurrentWeather
import com.example.android.weatherapp.domain.*
import com.google.gson.annotations.JsonAdapter

//@JsonClass(generateAdapter = true)
//data class NetworkCurrentWeatherContainer(val currentWeather = List<NetworkCurrentWeather>)
//
//
//data class NetworkCurrentWeather(
//    val base: String,
//    val clouds: Clouds,
//    val cod: Int,
//    val coord: Coord,
//    val dt: Int,
//    val id: Int,
//    val main: Main,
//    val name: String,
//    val sys: Sys,
//    val timezone: Int,
//    val visibility: Int,
//    val weather: List<Weather>,
//    val wind: Wind
//)
//
//fun NetworkCurrentWeatherContainer.asDomainModel(): Array<DatabaseCurrentWeather> {
//
//}