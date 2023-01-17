package com.example.weather_forecast.feature.weather_screen

import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherRepo

class WeatherInteractor(private val wr:IWeatherRepo) {
    suspend fun getTemperature(): String {
        return wr.getTemperature()
    }
}