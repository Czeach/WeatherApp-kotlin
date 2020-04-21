package com.example.android.weatherapp.network

import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import com.example.android.weatherapp.models.CurrentWeather
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


// A retrofit service to fetch a weather info.
interface OpenWeatherMapApi {
    @GET("weather?q=Enugu,Enugu&appid=c71d7cc39b34e871d2c9525737fdd3b8")
    fun getWeather(): Call<CurrentWeather>
}

// this is the main entry point for the network access. Call like `Network.weather.getWeather()`
object Network {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weather = retrofit.create(OpenWeatherMapApi::class.java)
}