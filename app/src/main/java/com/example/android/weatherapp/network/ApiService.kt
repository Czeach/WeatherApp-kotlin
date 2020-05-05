package com.example.android.weatherapp.network

import com.example.android.weatherapp.models.weather.CurrentWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "a18494d4eee39d449c841066b7e55685"

// weather url: https://api.openweathermap.org/data/2.5/weather?q=Enugu,Enugu&appid=a18494d4eee39d449c841066b7e55685
// forecast url: https://api.openweathermap.org/data/2.5/forecast/daily?id=2343279&cnt=7&appid=a18494d4eee39d449c841066b7e55685

// A retrofit service to fetch a data info.
interface OpenWeatherMapApi {

    // gets weather for a Searched location
    @GET("weather")
    fun getSearchedWeather(
        @Query("q") location: String,
        @Query("appid") apiKey: String
    ): CurrentWeather

    // gets weather for the device's location
    @GET("weather")
    fun getCurrentWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") apiKey: String
    ): CurrentWeather
}

// this is the main entry point for the network access. Call like `Network.data.getData()`
object Network {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val data = retrofit.create(OpenWeatherMapApi::class.java)
}