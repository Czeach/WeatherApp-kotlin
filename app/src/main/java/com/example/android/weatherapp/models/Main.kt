package com.example.android.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Main(
    @SerializedName("feels_like")
    var feelsLike: Double? = null,
    var humidity: Int? = null,
    var pressure: Int? = null,
    var temp: Double? = null,
    @SerializedName("temp_max")
    var tempMax: Double? = null,
    @SerializedName("temp_min")
    var tempMin: Double? = null
)