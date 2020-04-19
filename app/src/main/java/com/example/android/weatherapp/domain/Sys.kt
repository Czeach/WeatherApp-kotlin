package com.example.android.weatherapp.domain

//const val SYS_PRIMARY_KEY = 3
//
//@Entity (tableName = "current_sys")
data class Sys(

    // assign a primary key to the entity
//    @PrimaryKey(autoGenerate = false)
//    var sysPrimaryKey: Int = SYS_PRIMARY_KEY,

    val country: String,
    val sunrise: Int,
    val sunset: Int
)