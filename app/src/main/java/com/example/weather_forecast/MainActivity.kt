package com.example.weather_forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.widget.TextView
import com.example.weather_forecast.BuildConfig.DEBUG
import com.example.weather_forecast.feature.weather_screen.UI.WeatherScreenPresenter
import com.example.weather_forecast.feature.weather_screen.WeatherInteractor
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherApiClient
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRemoteSource
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRepoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var presenter : WeatherScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = WeatherScreenPresenter(WeatherInteractor(WeatherRepoImpl(
            WeatherRemoteSource(WeatherApiClient.getApi())
        )))

        val outText = findViewById<TextView>(R.id.outText)
        GlobalScope.launch {
            //Log.d("NET",presenter.interactor.getTemperature())
            withContext(Dispatchers.Main){
                outText.text = presenter.getWeather()
            }
        }




    }
}