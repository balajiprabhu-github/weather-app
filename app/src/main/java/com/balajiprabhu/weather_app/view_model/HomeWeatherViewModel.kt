package com.balajiprabhu.weather_app.view_model

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.balajiprabhu.weather_app.repository.models.base.WeatherResponse
import com.balajiprabhu.weather_app.repository.network.AppService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class HomeWeatherViewModel @Inject constructor(private val appService: AppService) : ViewModel(),
    LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getWeatherData() {
        appService.getWeatherResponse("coimbatore")
            .toObservable()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onSuccess,this::onError)
    }

    private fun onSuccess(weatherResponse: WeatherResponse){
        println(weatherResponse.toString())
    }

    private fun onError(throwable: Throwable){
        println(throwable.localizedMessage)
    }

    fun handleAppTheme(isChecked:Boolean) = if (isChecked) setNightModeOn() else setNightModeOff()

    private fun setNightModeOn() = AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

    private fun setNightModeOff() = AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

}