package com.example.android.weatherapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

const val WIND_PRIMARY_KEY = 2

@Entity (tableName = "current_wind")
data class Wind(

    // assign a primary key to the entity
    @PrimaryKey(autoGenerate = false)
    var windPrimaryKey: Int = WIND_PRIMARY_KEY,

    val deg: Int,
    val speed: Double
)