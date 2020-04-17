package com.example.android.weatherapp.data.database.local

import androidx.room.ColumnInfo

data class LocalSysMetric(
    @ColumnInfo(name = "sysPrimaryKey")
    override var sysPrimaryKey: Int,
    @ColumnInfo(name = "country")
    override val country: String,
    @ColumnInfo(name = "sunrise")
    override val sunrise: Int,
    @ColumnInfo(name = "sunset")
    override val sunset: Int

) : LocalSys