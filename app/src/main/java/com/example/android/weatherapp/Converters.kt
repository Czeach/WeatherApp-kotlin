package com.example.android.weatherapp

import androidx.room.TypeConverter
import com.example.android.weatherapp.models.Data
import com.example.android.weatherapp.models.Weather
import com.google.gson.Gson

class Converters  {

    @TypeConverter
    fun ListToJsonA(value: List<Data>?) = Gson().toJson(value)
    @TypeConverter
    fun JsonToListA(value: String) = Gson().fromJson(value, Array<Data>::class.java).toList()

    @TypeConverter
    fun ListToJsonB(value: List<Weather>?) = Gson().toJson(value)

    @TypeConverter
    fun JsonToListB(value: String) = Gson().fromJson(value, Array<Weather>::class.java).toList()
}