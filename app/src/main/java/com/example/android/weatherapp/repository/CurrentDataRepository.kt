package com.example.android.weatherapp.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.weatherapp.db.CurrentDataDatabase
import com.example.android.weatherapp.db.asDomainModel
import com.example.android.weatherapp.models.CurrentData
import com.example.android.weatherapp.network.Network
import com.example.android.weatherapp.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class CurrentDataRepository(private val database: CurrentDataDatabase) {

    val currentData: LiveData<List<CurrentData>> =
        Transformations.map(database.currentDataDao.getCurrentWeather()) {
            it.asDomainModel()
        }

    suspend fun RefreshCurrentData() {
        withContext(Dispatchers.IO) {
            Log.e("TAG","refresh current data is called")
            val currentDataList = Network.data.getWeather().await()
            database.currentDataDao.upsert(*currentDataList.asDatabaseModel())
        }
    }
}