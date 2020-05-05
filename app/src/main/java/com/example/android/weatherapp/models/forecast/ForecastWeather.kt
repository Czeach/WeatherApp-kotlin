package com.example.android.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName

data class ForecastWeather(
    val city: City? = null,
    val cnt: Int? = null,
    val cod: String? = null,
    @SerializedName("list")
    val list: List<Lists>? = null,
    val message: Double? = null
)