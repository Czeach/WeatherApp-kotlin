package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.CurrentData
import com.example.android.weatherapp.models.Data

const val PRIMARY_KEY = 1

@Entity(tableName = "current_data")
data class DatabaseCurrentData constructor(
    @PrimaryKey
    val count: Int,
    @Embedded(prefix = "data_")
    val data: List<Data>
)

fun List<DatabaseCurrentData>.asDomainModel(): List<CurrentData> {
    return map {
        CurrentData(
            count = it.count,
            data = it.data
        )
    }
}