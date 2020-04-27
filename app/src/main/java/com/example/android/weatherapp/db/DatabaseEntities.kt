package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.CurrentData
import com.example.android.weatherapp.models.Data

@Entity(tableName = "current_data")
data class DatabaseCurrentData constructor(
    @PrimaryKey
    val count: Int,
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