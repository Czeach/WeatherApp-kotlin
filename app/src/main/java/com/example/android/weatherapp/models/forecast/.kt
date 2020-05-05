package com.example.android.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName

data class (
    val clouds: Int? = null,
    val deg: Int? = null,
    val dt: Int? = null,
    @SerializedName("feels_like")
    val feelsLike: FeelsLike? = null,
    val humidity: Int? = null,
    val pressure: Int? = null,
    val rain: Double? = null,
    val speed: Double? = null,
    val sunrise: Int? = null,
    val sunset: Int? = null,
    val temp: Temp? = null,
    val weather: List<Weather>? = null
)