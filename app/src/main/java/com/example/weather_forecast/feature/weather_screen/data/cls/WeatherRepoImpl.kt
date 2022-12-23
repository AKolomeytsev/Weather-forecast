package com.example.weather_forecast.feature.weather_screen.data.cls

import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherRepo

class WeatherRepoImpl(private val wrs:WeatherRemoteSource) : IWeatherRepo {
    override fun getTemperature(): String {
        return wrs.getWeather().message()
    }
}