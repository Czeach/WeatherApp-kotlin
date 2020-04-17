package com.example.android.weatherapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.weatherapp.data.database.Dao.MainDao
import com.example.android.weatherapp.data.database.Dao.SysDao
import com.example.android.weatherapp.data.database.Dao.WeatherDao
import com.example.android.weatherapp.data.database.Dao.WindDao
import com.example.android.weatherapp.data.database.entity.Main
import com.example.android.weatherapp.data.database.entity.Sys
import com.example.android.weatherapp.data.database.entity.Weather
import com.example.android.weatherapp.data.database.entity.Wind

@Database(
    // add entities into the database
    entities = [Weather::class, Main::class, Wind::class, Sys::class],
    version = 1
)
abstract class ForecastDatabase : RoomDatabase() {

    // create instances of the DAOs
    abstract fun weatherDao() : WeatherDao
    abstract fun mainDao() : MainDao
    abstract fun windDao() : WindDao
    abstract fun sysDao() : SysDao

    companion object {
        // build the database
        // making a variable volatile gives all the threads immediate access it
        @Volatile
         private var instance: ForecastDatabase? = null
        private val LOCK = Any()

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ForecastDatabase::class.java,
                "forecast.db").build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // if instance is not null, set it to the build database function above
            instance ?: buildDatabase(context). also { instance = it }
        }
    }
}