package com.example.android.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName

data class City(
    val coord: Coord? = null,
    val country: String? = null,
    val id: Int? = null,
    val name: String? = null,
    val population: Int? = null,
    val timezone: Int? = null
)