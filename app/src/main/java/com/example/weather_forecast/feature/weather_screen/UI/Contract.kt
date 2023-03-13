package com.example.weather_forecast.feature.weather_screen.UI

import com.example.weather_forecast.feature.base.Event

data class ViewState(
    val title:String,
    val temperature:String
)

sealed class UiEvent():Event{
    object OnClickedButton:UiEvent()
}

sealed class DataEvent:Event{
    data class onWeatherFethcOk(val temperature: String):DataEvent()
}