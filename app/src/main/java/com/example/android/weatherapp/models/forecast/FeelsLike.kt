package com.example.android.weatherapp.models.forecast


import com.google.gson.annotations.SerializedName

data class FeelsLike(
    val day: Double? = null,
    val eve: Double? = null,
    val morn: Double? = null,
    val night: Double? = null
)