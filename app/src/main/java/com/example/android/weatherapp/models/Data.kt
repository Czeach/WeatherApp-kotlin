package com.example.android.weatherapp.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("app_temp")
    val appTemp: Double,
    val aqi: Int,
    @SerializedName("city_name")
    val cityName: String,
    val clouds: Int,
    @SerializedName("country_code")
    val countryCode: String,
    val datetime: String,
    val dewpt: Double,
    val dhi: Double,
    val dni: Double,
    @SerializedName("elev_angle")
    val elevAngle: Double,
    val ghi: Double,
    @SerializedName("h_angle")
    val hAngle: Int,
    @SerializedName("last_ob_time")
    val lastObTime: String,
    val lat: Double,
    val lon: Double,
    @SerializedName("ob_time")
    val obTime: String,
    val pod: String,
    val precip: Double,
    val pres: Double,
    val rh: Int,
    val slp: Double,
    val snow: Int,
    @SerializedName("solar_rad")
    val solarRad: Double,
    @SerializedName("state_code")
    val stateCode: String,
    val station: String,
    val sunrise: String,
    val sunset: String,
    val temp: Double,
    val timezone: String,
    val ts: Int,
    val uv: Double,
    val vis: Double,
    val weather: Weather,
    @SerializedName("wind_cdir")
    val windCdir: String,
    @SerializedName("wind_cdir_full")
    val windCdirFull: String,
    @SerializedName("wind_dir")
    val windDir: Int,
    @SerializedName("wind_spd")
    val windSpd: Double
)