package com.example.android.weatherapp.domain


// Domain objects are plain Kotlin data classes that represent the things in our app. These are the
// objects that should be displayed on screen, or manipulated by the app.
data class CurrentWeather constructor(
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
    val wind: Wind
)