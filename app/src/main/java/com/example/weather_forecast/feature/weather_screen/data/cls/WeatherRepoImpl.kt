package com.example.weather_forecast.feature.weather_screen.data.cls

import com.example.weather_forecast.feature.weather_screen.UI.model.WeatherModel
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherRepo
import com.example.weather_forecast.feature.weather_screen.data.model.toDomain

class WeatherRepoImpl(private val wrs:WeatherRemoteSource) : IWeatherRepo {
    override suspend fun getTemperature(): WeatherModel {
        return wrs.getWeather().toDomain()
    }
}