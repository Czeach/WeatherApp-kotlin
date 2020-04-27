package com.example.android.weatherapp.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.android.weatherapp.models.*


@Entity(tableName = "current_weather")
data class DatabaseCurrentWeather constructor(
    @PrimaryKey(autoGenerate = false)
    var primaryKey: Int = PRIMARY_KEY,
    var base: String? = null,
    @Embedded(prefix = "clouds_")
    var clouds: Clouds? = null,
    var cod: Int? = null,
    @Embedded(prefix = "coord_")
    var coord: Coord? = null,
    var dt: Int? = null,
    var id: Int? = null,
    @Embedded(prefix = "main_")
    var main: Main? =  null,
    var name: String? = null,
    @Embedded(prefix = "sys_")
    var sys: Sys? = null,
    var timezone: Int? = null,
    var visibility: Int? = null,
    @Embedded(prefix = "weather_")
    var weather: List<Weather>? = null,
    @Embedded(prefix = "wind_")
    var wind: Wind? = null
)

fun List<DatabaseCurrentWeather>.asDomainModel(): List<CurrentWeather> {
    return map {
        CurrentWeather(
            base = it.base!!,
            clouds = it.clouds,
            cod = it.cod!!,
            coord = it.coord,
            dt = it.dt!!,
            id = it.id!!,
            main = it.main,
            name = it.name!!,
            sys = it.sys,
            timezone = it.timezone!!,
            visibility = it.visibility!!,
            weather = it.weather,
            wind = it.wind
        )
    }
}