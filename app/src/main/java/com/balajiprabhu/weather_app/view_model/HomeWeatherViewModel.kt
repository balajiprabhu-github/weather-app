package com.balajiprabhu.weather_app.view_model

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModel

class HomeWeatherViewModel : ViewModel() {

    fun handleAppTheme(isChecked:Boolean) = if (isChecked) setNightModeOn() else setNightModeOff()

    private fun setNightModeOn() = AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

    private fun setNightModeOff() = AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

}