package com.example.weather_forecast.feature.weather_screen.di

import com.example.weather_forecast.BASE_URL_WEATHER
import com.example.weather_forecast.feature.weather_screen.UI.WeatherScreenViewModel
import com.example.weather_forecast.feature.weather_screen.WeatherInteractor
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRemoteSource
import com.example.weather_forecast.feature.weather_screen.data.cls.WeatherRepoImpl
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherApi
import com.example.weather_forecast.feature.weather_screen.data.interfaces.IWeatherRepo
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

    single<OkHttpClient> { OkHttpClient.Builder().build() }
    single<Retrofit> {  Retrofit.Builder()
        .baseUrl(BASE_URL_WEATHER)
        .addConverterFactory(GsonConverterFactory.create())
        .client(get<OkHttpClient>())
        .build()
    }
    single<IWeatherApi>{get<Retrofit>().create(IWeatherApi::class.java)}

    single { WeatherRemoteSource(get<IWeatherApi>()) }

    single<IWeatherRepo> {WeatherRepoImpl(get<WeatherRemoteSource>())  }

    single<WeatherInteractor> { WeatherInteractor(get<IWeatherRepo>()) }

    viewModel { WeatherScreenViewModel(get<WeatherInteractor>()) }

}