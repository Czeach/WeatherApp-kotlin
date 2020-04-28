package com.example.android.weatherapp.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.weatherapp.db.WeatherDataDatabase
import com.example.android.weatherapp.db.asDomainModel
import com.example.android.weatherapp.models.WeatherData
import com.example.android.weatherapp.network.Network
import com.example.android.weatherapp.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class WeatherDataRepository(private val database: WeatherDataDatabase?) {

    val currentData: LiveData<List<WeatherData?>> =
        Transformations.map(database?.weatherDataDao!!.getWeatherData()) {
            it.asDomainModel()
        }

    suspend fun refreshCurrentData() {
        withContext(Dispatchers.IO) {
            Log.e("TAG","refresh current data is called")
            val weatherDataList = Network.data.getWeather().await()
            database?.weatherDataDao?.upsert(*weatherDataList.asDatabaseModel())
        }
    }
}