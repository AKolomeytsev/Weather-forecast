package com.example.weather_forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.weather_forecast.feature.weather_screen.UI.UiEvent
import com.example.weather_forecast.feature.weather_screen.UI.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel : com.example.weather_forecast.feature.weather_screen.UI.WeatherScreenViewModel by viewModel()
    private val outText : TextView by lazy { findViewById<TextView>(R.id.outText) }
    private val getTemperatureButton : Button by lazy { findViewById<Button>(R.id.buttonQueryTemperature) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.viewState.observe(this,::render)

        getTemperatureButton.setOnClickListener {
            viewModel.processUiEvent(UiEvent.OnClickedButton)
        }

        /*GlobalScope.launch {
            withContext(Dispatchers.Main){
                outText.text = presenter.getWeather()
            }
        }*/
    }

    private fun render(viewState: ViewState){
        outText.text = "${viewState.title} ${viewState.temperature}"
    }
}