package com.example.weather_forecast.Activity

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.weather_forecast.R

class WeatherActivity: AppCompatActivity() {
    private  val weatherPrisenter = WeatherPrisenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_weather)

        val temperatureView = findViewById<TextView>(R.id.headTextWeather)
        temperatureView.text = weatherPrisenter.getWether()

    }

}