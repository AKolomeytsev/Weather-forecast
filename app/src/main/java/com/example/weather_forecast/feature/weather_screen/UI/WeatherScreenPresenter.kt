package com.example.weather_forecast.feature.weather_screen.UI

import com.example.weather_forecast.feature.weather_screen.WeatherInteractor

class WeatherScreenPresenter(val interactor: WeatherInteractor) {
    suspend fun getWeather():String{
        return interactor.getTemperature()
    }
}