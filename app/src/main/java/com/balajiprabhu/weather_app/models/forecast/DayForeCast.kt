package com.balajiprabhu.weather_app.models.forecast

import com.balajiprabhu.weather_app.models.base.Clouds

data class DayForeCast(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Int,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)