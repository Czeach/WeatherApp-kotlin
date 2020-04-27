package com.example.android.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Weather(
    var description: String? = null,
    var icon: String? = null,
    var id: Int? = null,
    var main: String? = null
)