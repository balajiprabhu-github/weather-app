package com.balajiprabhu.weather_app.repository.models.base

data class WeatherResponse(
        val base: String,
        val clouds: Clouds,
        val cod: Int,
        val coord: Coord,
        val dt: Int,
        val id: Int,
        val main: Main,
        val name: String,
        val sys: Sys,
        val timezone: Int,
        val visibility: Int,
        val weather: List<Weather>,
        val wind: Wind
){
        override fun toString(): String {
                return "base: $base\n," +
                        "clouds: $clouds\n," +
                        "cod: $cod,\n" +
                        "coord: $coord\n" +
                        "dt: $dt,\n" +
                        "id: $id,\n" +
                        "main: $main\n" +
                        "name: $name\n" +
                        "sys: $sys,\n" +
                        "timezone: $timezone\n" +
                        "visibility: $visibility\n" +
                        "weather: $weather\n" +
                        "wind: $wind"
        }
}