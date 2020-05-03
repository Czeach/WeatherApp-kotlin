package com.example.android.weatherapp.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.android.weatherapp.models.WeatherData
import com.example.android.weatherapp.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


//class WeatherDataRepository(private val database: WeatherDataDatabase) {
//
//    val currentData: LiveData<List<WeatherData?>> =
//        Transformations.map(database.weatherDataDao.getWeatherData()) {
//            it.asDomainModel()
//        }
//
//    suspend fun refreshVideos() {
//        withContext(Dispatchers.IO) {
//            val weatherDataList = Network.data.getWeather().await()
//            database.weatherDataDao.upsert(*weatherDataList.asDatabaseModel())
//        }
//    }
//}