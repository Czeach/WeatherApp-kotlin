package com.example.android.weatherapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.android.weatherapp.Converters
import com.example.android.weatherapp.models.CurrentData


@Dao
interface CurrentDataDao {
    @Query("select * from current_data")
    fun getCurrentWeather(): LiveData<List<DatabaseCurrentData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(currentData: DatabaseCurrentData)
}

@Database(
    entities = [DatabaseCurrentData::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CurrentDataDatabase: RoomDatabase() {
    abstract val currentDataDao: CurrentDataDao

    companion object {
        private lateinit var INSTANCE: CurrentDataDatabase

        fun getDatabase(context: Context): CurrentDataDatabase {
            synchronized(CurrentDataDatabase::class.java) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CurrentDataDatabase::class.java,
                        "current_data").build()
                }
            }
            return INSTANCE
        }
    }
}