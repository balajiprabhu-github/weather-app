package com.balajiprabhu.weather_app.models.base

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)