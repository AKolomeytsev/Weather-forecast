package com.example.weather_forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.weather_forecast.feature.weather_screen.UI.WeatherScreenPresenter
import com.example.weather_forecast.feature.weather_screen.WeatherInteractor
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRemoteSource
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val presenter : WeatherScreenPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val outText = findViewById<TextView>(R.id.outText)
        GlobalScope.launch {
            withContext(Dispatchers.Main){
                outText.text = presenter.getWeather()
            }
        }
    }
}