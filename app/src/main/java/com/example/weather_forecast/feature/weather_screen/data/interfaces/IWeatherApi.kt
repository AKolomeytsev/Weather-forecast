package com.example.weather_forecast.feature.weather_screen.data.interfaces

import com.example.weather_forecast.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IWeatherApi {
    @GET("weather")
    fun getWeather(
        @Query("lat") lat: Double
        ,@Query("lon") lon: Double
        ,@Query("appid") appid: String = API_KEY
    ):Response<String>
}