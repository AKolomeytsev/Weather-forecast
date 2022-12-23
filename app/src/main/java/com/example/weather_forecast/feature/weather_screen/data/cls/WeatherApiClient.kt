package com.example.weather_forecast.feature.weather_screen.data.cls

import com.example.weather_forecast.BASE_URL_WEATHER
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object WeatherApiClient {
    private val okHttpClient = OkHttpClient.Builder().build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_WEATHER)
        .client(okHttpClient)
        .build()
    private val weatherApi  = retrofit.create(IWeatherApi::class.java)

    fun getApi(): IWeatherApi {
        return weatherApi;
    }

}