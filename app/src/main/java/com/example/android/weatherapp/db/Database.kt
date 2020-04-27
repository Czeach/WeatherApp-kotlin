package com.example.android.weatherapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface CurrentWeatherDao {
    @Query("select * from current_weather")
    fun getCurrentWeather(): LiveData<List<DatabaseCurrentWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentWeather: DatabaseCurrentWeather)
}

@Database(
    entities = [DatabaseCurrentWeather::class],
    version = 1
)
abstract class CurrentWeatherDatabase: RoomDatabase() {
    abstract val currentWeatherDao: CurrentWeatherDao

    companion object {
        private var INSTANCE: CurrentWeatherDatabase? = null

        fun getDatabase(context: Context): CurrentWeatherDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CurrentWeatherDatabase::class.java,
                    "current_weather_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}