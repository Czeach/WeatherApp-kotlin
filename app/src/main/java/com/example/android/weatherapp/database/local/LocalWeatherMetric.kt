package com.example.android.weatherapp.database.local

import androidx.room.ColumnInfo

data class LocalWeatherMetric(
    @ColumnInfo(name = "weatherPrimaryKey")
    override var weatherPrimaryKey: Int,
    @ColumnInfo(name = "description")
    override val description: String,
    @ColumnInfo(name = "icon")
    override val icon: String,
    @ColumnInfo(name = "id")
    override val id: Int,
    @ColumnInfo(name = "main")
    override val main: String
) : LocalWeather