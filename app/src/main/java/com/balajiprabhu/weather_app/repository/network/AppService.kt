package com.balajiprabhu.weather_app.repository.network

import com.balajiprabhu.weather_app.repository.models.base.WeatherResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface AppService {

    @GET(value = "/weather")
    fun getWeatherResponse(@Query("q") query: String) : Single<WeatherResponse>

}