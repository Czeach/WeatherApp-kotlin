package com.example.android.weatherapp.domain


import com.google.gson.annotations.SerializedName

//const val MAIN_PRIMARY_KEY = 1
//
//@Entity (tableName = "current_main")
data class Main(

//    // assign a primary key to the entity
//    @PrimaryKey (autoGenerate = false)
//    var mainPrimaryKey: Int = MAIN_PRIMARY_KEY,

    @SerializedName("feels_like")
    val feelsLike: Double,
    val humidity: Int,
    val pressure: Int,
    val temp: Double,
    @SerializedName("temp_max")
    val tempMax: Double,
    @SerializedName("temp_min")
    val tempMin: Double
)