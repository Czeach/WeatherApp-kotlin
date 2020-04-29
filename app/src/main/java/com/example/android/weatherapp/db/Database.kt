package com.example.android.weatherapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.weatherapp.converter.Converters


@Dao
interface WeatherDataDao {
    @Query("select * from weather_data")
    fun getWeatherData(): LiveData<List<DatabaseWeatherData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(vararg currentData: DatabaseWeatherData)
}

@Database(
    entities = [DatabaseWeatherData::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class WeatherDataDatabase: RoomDatabase() {
    abstract val weatherDataDao: WeatherDataDao
}

    private lateinit var INSTANCE: WeatherDataDatabase

    fun getDatabase(context: Context): WeatherDataDatabase {
        synchronized(WeatherDataDatabase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context.applicationContext,
                    WeatherDataDatabase::class.java,
                    "current_data").build()
            }
        }
        return INSTANCE
    }
