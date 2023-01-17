package com.example.weather_forecast.feature.weather_screen.data.cls

import com.example.weather_forecast.API_KEY
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherApi
import com.example.weather_forecast.feature.weather_screen.data.model.WeatherRemoteModel
import retrofit2.Response

class WeatherRemoteSource(private val api:IWeatherApi) {
    suspend fun getWeather(): WeatherRemoteModel {
        return api.getWeather(44.34,10.99, API_KEY)
    }
}