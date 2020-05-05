package com.example.android.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName

data class Weather(
    val description: String? = null,
    val icon: String? = null,
    val id: Int? = null,
    val main: String? = null
)