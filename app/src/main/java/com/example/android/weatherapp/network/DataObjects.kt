package com.example.android.weatherapp.network

import androidx.room.PrimaryKey
import com.example.android.weatherapp.db.DatabaseCurrentData
import com.example.android.weatherapp.models.CurrentData
import com.example.android.weatherapp.models.Data

data class NetworkCurrentDataContainer(
    val currentData: List<NetworkCurrentData>
)

data class NetworkCurrentData(
    val count: Int,
    val data: List<Data>
)

fun NetworkCurrentDataContainer.asDomainModel(): List<CurrentData> {
    return currentData.map {
        CurrentData(
            count = it.count,
            data = it.data
        )
    }
}

fun NetworkCurrentDataContainer.asDatabaseModel(): Array<DatabaseCurrentData> {
    return currentData.map {
        DatabaseCurrentData(
            count = it.count,
            data = it.data
        )
    }.toTypedArray()
}