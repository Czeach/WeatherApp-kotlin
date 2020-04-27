package com.example.android.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Sys(
    var country: String? = null,
    var id: Int? = null,
    var sunrise: Int? = null,
    var sunset: Int? = null,
    var type: Int? = null
)