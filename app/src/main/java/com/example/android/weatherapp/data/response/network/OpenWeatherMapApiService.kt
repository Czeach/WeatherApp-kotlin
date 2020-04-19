package com.example.android.weatherapp.data.response.network

import com.example.android.weatherapp.data.response.ConnectionInterceptor
import com.example.android.weatherapp.data.response.ConnectionInterceptorImpl
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// API key
const val API_KEY = "c71d7cc39b34e871d2c9525737fdd3b8"

//    BASE_URL = "https://api.openweathermap.org/data/2.5/weather?q=Enugu,Enugu&appid=c71d7cc39b34e871d2c9525737fdd3b8"

// Retrofit will fetch the data from this API
interface OpenWeatherMapApiService {
    // get weather from the url
    @GET("weather?q=Enugu,Enugu&appid=c71d7cc39b34e871d2c9525737fdd3b8")
    fun getCurrentWeather(): Deferred<CurrentWeatherResponse>

    //    // a class that fetches the api from getCurrentWeather
    companion object {
        operator fun invoke(connectionInterceptor : ConnectionInterceptor): OpenWeatherMapApiService {
            // put the API_KEY for every API call
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                        // 'name: "appid"' is from the BASE_URL
                    .addQueryParameter("appid",
                        API_KEY
                    )
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectionInterceptor)
                .build()

            // return OpenWeatherMapApiService from the invoke() fun
            return  Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                    // specify a call factory for the retrofit call
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                // specify a converter factory for the retrofit call
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OpenWeatherMapApiService::class.java)
        }
    }
}