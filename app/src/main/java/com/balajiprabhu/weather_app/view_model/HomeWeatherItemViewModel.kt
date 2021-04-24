package com.balajiprabhu.weather_app.view_model

import androidx.databinding.ObservableField

class HomeWeatherItemViewModel constructor(temperature:String,city:String,country:String,weatherIcon:String) {
    val temperature = ObservableField<String>(temperature)
    val city = ObservableField<String>(city)
    val country = ObservableField<String>(country)
    val weatherIcon = ObservableField<String>(weatherIcon)
}