package com.example.android.weatherapp.data.database.local

import androidx.room.ColumnInfo

data class LocalWindMetric(
    @ColumnInfo(name = "windPrimaryKey")
    override var windPrimaryKey: Int,
    @ColumnInfo(name = "deg")
    override val degree: Int,
    @ColumnInfo(name = "speed")
    override val speed: Double
): LocalWind