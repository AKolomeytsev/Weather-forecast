package com.example.weather_forecast.feature.weather_screen.UI

import androidx.lifecycle.viewModelScope
import com.example.weather_forecast.feature.base.BaseViewModel
import com.example.weather_forecast.feature.base.Event
import com.example.weather_forecast.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor):BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState = ViewState(title = "Hellow Word",temperature = "")

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnClickedButton -> {
                viewModelScope.launch {
                    processDataEvent(DataEvent.onWeatherFethcOk(temperature = interactor.getTemperature()))
                }
                return null

            }


            is DataEvent.onWeatherFethcOk ->{
                return previousState.copy(temperature = event.temperature)
            }
            else -> return null

        }
    }
}