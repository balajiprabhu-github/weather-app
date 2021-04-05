package com.balajiprabhu.weather_app.view_model

import android.graphics.drawable.Drawable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class HomeWeatherItemViewModel : ViewModel() {

    val temperature = ObservableField<String>("")
    val city = ObservableField<String>("")
    val country = ObservableField<String>("")
    val weatherIcon = ObservableField<Drawable>()
}