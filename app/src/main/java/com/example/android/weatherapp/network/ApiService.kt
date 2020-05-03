package com.example.android.weatherapp.network

import com.example.android.weatherapp.models.WeatherData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// BASE_URL = "https://api.openweathermap.org/data/2.5/onecall?lat=6.44&lon=7.49&appid=c71d7cc39b34e871d2c9525737fdd3b8"

// A retrofit service to fetch a data info.
interface OpenWeatherMapApi {
    @GET("onecall?lat=6.44&lon=7.49&appid=c71d7cc39b34e871d2c9525737fdd3b8")
    fun getWeather(): ArrayList<WeatherData>
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