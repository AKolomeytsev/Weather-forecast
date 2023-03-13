package com.example.weather_forecast.feature.weather_screen.data.interfaces

import com.example.weather_forecast.feature.weather_screen.UI.model.WeatherModel

interface IWeatherRepo {
    suspend fun getTemperature():WeatherModel
}