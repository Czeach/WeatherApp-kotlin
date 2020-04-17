package com.example.android.weatherapp.data.database.local

import androidx.room.ColumnInfo

data class LocalMainMetric(
    @ColumnInfo(name = "feels_like")
    override val feelsLike: Double,
    @ColumnInfo(name = "humidity")
    override val humidity: Int,
    @ColumnInfo(name = "pressure")
    override val pressure: Int,
    @ColumnInfo(name = "temp")
    override val temperature: Double,
    @ColumnInfo(name = "temp_max")
    override val temperatureMax: Double,
    @ColumnInfo(name = "temp_min")
    override val temperatureMin: Double

) : LocalMain