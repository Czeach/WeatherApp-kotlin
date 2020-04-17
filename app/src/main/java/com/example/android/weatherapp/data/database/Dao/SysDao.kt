package com.example.android.weatherapp.data.database.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.weatherapp.data.database.entity.SYS_PRIMARY_KEY
import com.example.android.weatherapp.data.database.entity.Sys
import com.example.android.weatherapp.data.database.local.LocalSysMetric

@Dao
interface SysDao {

    // Insert and update the wind sys class in the db
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(sys: Sys)

    @Query("select * from current_sys where sysPrimaryKey = $SYS_PRIMARY_KEY")
    fun getLocalSysMetric() : LiveData<LocalSysMetric>
}