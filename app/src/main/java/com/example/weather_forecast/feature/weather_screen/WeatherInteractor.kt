package com.example.weather_forecast.feature.weather_screen

import com.example.weather_forecast.feature.base.Either
import com.example.weather_forecast.feature.base.attempt
import com.example.weather_forecast.feature.weather_screen.UI.model.WeatherModel
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherRepo

class WeatherInteractor(private val wr:IWeatherRepo) {
    suspend fun getTemperature(): Either<Throwable, WeatherModel> {
        return attempt { wr.getTemperature() }
    }
}