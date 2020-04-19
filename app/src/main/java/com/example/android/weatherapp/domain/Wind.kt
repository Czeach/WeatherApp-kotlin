package com.example.android.weatherapp.domain

//const val WIND_PRIMARY_KEY = 2
//
//@Entity (tableName = "current_wind")
data class Wind(

    // assign a primary key to the entity
//    @PrimaryKey(autoGenerate = false)
//    var windPrimaryKey: Int = WIND_PRIMARY_KEY,

    val deg: Int,
    val speed: Double
)