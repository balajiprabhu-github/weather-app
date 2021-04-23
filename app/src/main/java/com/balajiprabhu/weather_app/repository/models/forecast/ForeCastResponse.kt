package com.balajiprabhu.weather_app.repository.models.forecast

data class ForeCastResponse(
        val city: City,
        val cnt: Int,
        val cod: String,
        val list: List<DayForeCast>,
        val message: Int
)