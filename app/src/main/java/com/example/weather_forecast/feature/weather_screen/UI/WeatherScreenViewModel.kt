package com.example.weather_forecast.feature.weather_screen.UI

import androidx.lifecycle.viewModelScope
import com.example.weather_forecast.feature.base.BaseViewModel
import com.example.weather_forecast.feature.base.Event
import com.example.weather_forecast.feature.weather_screen.WeatherInteractor
import kotlinx.coroutines.launch

class WeatherScreenViewModel(val interactor: WeatherInteractor):BaseViewModel<ViewState>() {
    override fun initialViewState(): ViewState = ViewState(isLoading = false, title = "Hellow Word", temperature = null)

    override fun reduce(event: Event, previousState: ViewState): ViewState? {
        when (event) {
            is UiEvent.OnClickedButton -> {
                viewModelScope.launch {
                    interactor.getTemperature().fold(
                        onSuccess = {
                            processDataEvent(DataEvent.onWeatherFethcOk(temperature = it.temperature))
                        },
                        onError = {
                            processDataEvent(DataEvent.onWeatherFethcError(error = it))
                        }
                    )
                }
                return previousState.copy(isLoading = true)
            }

            is DataEvent.onWeatherFethcOk ->{
                return previousState.copy(isLoading = false, temperature = event.temperature)
            }
            else -> return null
        }
    }
}