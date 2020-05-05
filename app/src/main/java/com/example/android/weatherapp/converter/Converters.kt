package com.example.android.weatherapp.converter

import androidx.room.TypeConverter
import com.example.android.weatherapp.models.weather.Weather
import com.google.gson.Gson

class Converters  {

    @TypeConverter
    fun listToJsonCurrent(value: List<Current>) = Gson().toJson(value)
    @TypeConverter
    fun listToJsonCurrent(value: String) = Gson().fromJson(value, Array<Current>::class.java).toList()

    @TypeConverter
    fun listToJsonDaily(value: List<Daily>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListDaily(value: String) = Gson().fromJson(value, Array<Daily>::class.java).toList()

    @TypeConverter
    fun listToJsonHourly(value: List<Hourly>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListHourly(value: String) = Gson().fromJson(value, Array<Hourly>::class.java).toList()

    @TypeConverter
    fun listToJsonWeather(value: List<Weather>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListWeather(value: String) = Gson().fromJson(value, Array<Weather>::class.java).toList()

    @TypeConverter
    fun listToJsonFeels(value: List<FeelsLike>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListFeels(value: String) = Gson().fromJson(value, Array<FeelsLike>::class.java).toList()

    @TypeConverter
    fun listToJsonTemp(value: List<Temp>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListTemp(value: String) = Gson().fromJson(value, Array<Temp>::class.java).toList()

    @TypeConverter
    fun listToJsonDailyWeatherX(value: List<WeatherX>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListWeatherX(value: String) = Gson().fromJson(value, Array<WeatherX>::class.java).toList()

    @TypeConverter
    fun listToJsonRain(value: List<Rain>) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListRain(value: String) = Gson().fromJson(value, Array<Rain>::class.java).toList()

    @TypeConverter
    fun listToJsonWeatherXX(value: List<WeatherXX>?) = Gson().toJson(value)
    @TypeConverter
    fun jsonToListWeatherXX(value: String) = Gson().fromJson(value, Array<WeatherXX>::class.java).toList()
}