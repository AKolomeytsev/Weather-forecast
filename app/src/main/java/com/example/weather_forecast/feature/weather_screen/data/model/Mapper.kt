package com.example.weather_forecast.feature.weather_screen.data.model

import com.example.weather_forecast.feature.weather_screen.UI.model.WeatherModel

fun WeatherRemoteModel.toDomain() = WeatherModel(
    temperature = this.main.temperature
)