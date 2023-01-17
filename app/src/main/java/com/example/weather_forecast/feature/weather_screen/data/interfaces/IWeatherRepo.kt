package com.example.weather_forecast.feature.weather_screen.data.interfaces

interface IWeatherRepo {
    suspend fun getTemperature():String
}