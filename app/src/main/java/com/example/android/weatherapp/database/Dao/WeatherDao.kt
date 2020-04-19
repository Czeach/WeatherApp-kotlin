package com.example.android.weatherapp.database.Dao

//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//import com.example.android.weatherapp.domain.WEATHER_PRIMARY_KEY
//import com.example.android.weatherapp.domain.Weather
//import com.example.android.weatherapp.database.local.LocalWeatherMetric
//
//
//@Dao
//interface CurrentWeatherDao {
//
//    // Insert and save the weather data class
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun upsert (weather: Weather)
//
//    @Query("select * from current_weather where weatherPrimaryKey = $WEATHER_PRIMARY_KEY")
//    fun getLocalWeatherMetric() : LiveData<LocalWeatherMetric>
//}