package com.balajiprabhu.weather_app.di.home

import com.balajiprabhu.weather_app.view.adapter.WeatherListAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @HomeScope
    @Provides
    fun providesWeatherListAdapter(): WeatherListAdapter = WeatherListAdapter()
}