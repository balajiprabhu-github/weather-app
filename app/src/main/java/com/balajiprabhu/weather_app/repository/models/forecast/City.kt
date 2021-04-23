package com.balajiprabhu.weather_app.repository.models.forecast

import com.balajiprabhu.weather_app.repository.models.base.Coord

data class City(
        val coord: Coord,
        val country: String,
        val id: Int,
        val name: String,
        val population: Int,
        val sunrise: Int,
        val sunset: Int,
        val timezone: Int
)