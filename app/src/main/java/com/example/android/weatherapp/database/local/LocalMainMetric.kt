package com.example.android.weatherapp.database.local

import androidx.room.ColumnInfo

data class LocalMainMetric(
    @ColumnInfo(name = "mainPrimaryKey")
    override var mainPrimaryKey: Int,
    @ColumnInfo(name = "feelsLike")
    override val feelsLike: Double,
    @ColumnInfo(name = "humidity")
    override val humidity: Int,
    @ColumnInfo(name = "pressure")
    override val pressure: Int,
    @ColumnInfo(name = "temp")
    override val temperature: Double,
    @ColumnInfo(name = "tempMax")
    override val temperatureMax: Double,
    @ColumnInfo(name = "tempMin")
    override val temperatureMin: Double

) : LocalMain