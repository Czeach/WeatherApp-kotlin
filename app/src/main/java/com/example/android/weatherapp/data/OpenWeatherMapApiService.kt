package com.example.android.weatherapp.data

import com.example.android.weatherapp.data.response.CurrentWeatherResponse
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

private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

private val retrofit =Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL).build()

interface OpenWeatherMapApiService {
    @GET("weather?q=Enugu,Enugu&appid=c71d7cc39b34e871d2c9525737fdd3b8")
    suspend fun getProperties(): Deferred<CurrentWeatherResponse>
}

object WeatherApi{
    val retrofitService: OpenWeatherMapApiService by lazy {
        retrofit.create(OpenWeatherMapApiService::class.java)
    }
}

// Retrofit will fetch the data from this API
//interface OpenWeatherMapApiService {
//
//    // get weather from the url
//    @GET("weather")
//    fun getCurrentWeather(
//        // specify query parameters from the url, city in this case
////        @Query("q") location: String
//    ): Deferred<CurrentWeatherResponse>
//
//    // a class that fetches the api from getCurrentWeather
//    companion object {
//        operator fun invoke(): OpenWeatherMapApiService {
//            // put the API_KEY for every API call
//            val requestInterceptor = Interceptor {chain ->
//                val url = chain.request()
//                    .url()
//                    .newBuilder()
//                        // 'name: "appid"' is from the BASE_URL
//                    .addQueryParameter("appid", API_KEY)
//                    .build()
//                val request = chain.request()
//                    .newBuilder()
//                    .url(url)
//                    .build()
//
//                return@Interceptor chain.proceed(request)
//            }
//            val okHttpClient = OkHttpClient.Builder()
//                .addInterceptor(requestInterceptor)
//                .build()
//
//            // return OpenWeatherMapApiService from the invoke() fun
//            return  Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl("https://api.openweathermap.org/data/2.5/")
//                    // specify a call factory for the retrofit call
//                .addCallAdapterFactory(CoroutineCallAdapterFactory())
//                // specify a converter factory for the retrofit call
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(OpenWeatherMapApiService::class.java)
//        }
//    }
//}