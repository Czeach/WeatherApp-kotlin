package com.example.android.weatherapp.network

import com.example.android.weatherapp.models.CurrentData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// BASE_URL = "https://api.weatherbit.io/v2.0/current?city=Enugu,NG&key=322cd626ddc449bf9f149f4f8b48e0a4"

// A retrofit service to fetch a data info.
interface WeatherBitApi {
    @GET("current?city=Enugu,NG&key=322cd626ddc449bf9f149f4f8b48e0a4")
    fun getWeather(): Call<CurrentData>
}

// this is the main entry point for the network access. Call like `Network.data.getData()`
object Network {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherbit.io/v2.0/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val data = retrofit.create(WeatherBitApi::class.java)
}