package com.example.android.weatherapp.data.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.weatherapp.data.database.entity.WIND_PRIMARY_KEY
import com.example.android.weatherapp.data.database.entity.Wind
import com.example.android.weatherapp.data.database.local.LocalWindMetric

@Dao
interface WindDao {

    // Insert and update the wind data class in the db
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun upsert(wind: Wind)

    @Query("select * from current_wind where windPrimaryKey = $WIND_PRIMARY_KEY")
    fun getLocalWindMetric(): LiveData<LocalWindMetric>
}