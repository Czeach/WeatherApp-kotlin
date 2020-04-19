package com.example.android.weatherapp.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CurrentWeatherDao {
    @Query("select * from current_weather where primaryKey = $PRIMARY_KEY")
    fun getVideos() : LiveData<List<DatabaseCurrentWeather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertAll(vararg videos: DatabaseCurrentWeather)
}

@Database(
    // add entities into the database
    entities = [DatabaseCurrentWeather::class],
    version = 1
)
abstract class WeatherDatabase : RoomDatabase() {
    // create instances of the DAOs
//    abstract val weatherDao: CurrentWeatherDao
//    abstract val mainDao: MainDao
//    abstract val windDao: WindDao
//    abstract val sysDao: SysDao

    abstract val currentWeatherDao: CurrentWeatherDao
}

    private lateinit var INSTANCE: WeatherDatabase

    private fun buildDatabase(context: Context): WeatherDatabase {
        synchronized(WeatherDatabase::class.java) {
            if (::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    WeatherDatabase::class.java,
                    "Forecast"
                ).build()
            }
        }
        return INSTANCE
    }
//    companion object {
//        // build the database
//        // making a variable volatile gives all the threads immediate access it
//        @Volatile
//         private var instance: WeatherDatabase? = null
//        private val LOCK = Any()
//
//        private fun buildDatabase(context: Context) =
//            Room.databaseBuilder(context.applicationContext,
//                WeatherDatabase::class.java,
//                "forecast.db").build()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            // if instance is not null, set it to the build database function above
//            instance ?: buildDatabase(context). also { instance = it }
//        }
//    }
//}