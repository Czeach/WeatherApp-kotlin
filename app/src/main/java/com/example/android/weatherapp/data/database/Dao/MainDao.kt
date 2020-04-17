package com.example.android.weatherapp.data.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.weatherapp.data.database.entity.MAIN_PRIMARY_KEY
import com.example.android.weatherapp.data.database.entity.Main
import com.example.android.weatherapp.data.database.local.LocalMainMetric

@Dao
interface MainDao {

    // Insert and update the main data class in the db
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun upsert (main: Main)

    @Query("select * from current_main where mainPrimaryKey = $MAIN_PRIMARY_KEY")
    fun getLocalMainMetric() : LiveData<LocalMainMetric>
}