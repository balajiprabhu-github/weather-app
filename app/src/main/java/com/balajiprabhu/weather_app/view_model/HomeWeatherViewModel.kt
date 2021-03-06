package com.balajiprabhu.weather_app.view_model

import androidx.appcompat.app.AppCompatDelegate
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel
import com.balajiprabhu.weather_app.app.AppPreferences
import com.balajiprabhu.weather_app.repository.models.base.WeatherResponse
import com.balajiprabhu.weather_app.repository.network.AppService
import com.balajiprabhu.weather_app.view.adapter.WeatherListAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableSource
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject

class HomeWeatherViewModel @Inject constructor(
    private val appService: AppService,
    val weatherListAdapter: WeatherListAdapter
) : ViewModel(), LifecycleObserver {

    val includeEdge = ObservableBoolean(false)
    val isNightModeEnabled = ObservableBoolean(AppPreferences.isNightModeEnabled)
    private val homeWeatherItemViewModels = mutableListOf<HomeWeatherItemViewModel>()

    private val cityList = listOf<String>("Coimbatore","Chennai","London","Delhi")

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun getWeatherData() {
        cityList.forEach {
            appService.getWeatherResponse(it,"36e277b460aae4e07502a9ebf28df625")
                .toObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError)
        }
    }

    private fun onSuccess(weatherResponse: WeatherResponse) {
        weatherResponse.let {
            val loc = Locale("", it.sys.country)
            val temp = (it.main.temp - 273.15).toInt()
            val homeWeatherItemViewModel = HomeWeatherItemViewModel(
                String.format("$temp%s",0x00B0.toChar()),
                it.name,
                loc.displayCountry,
                it.weather[0].icon
            )
            homeWeatherItemViewModels.add(homeWeatherItemViewModel)
        }

        homeWeatherItemViewModels.isNotEmpty().let {
            weatherListAdapter.setWeatherItemListData(homeWeatherItemViewModels)
        }

    }

    private fun onError(throwable: Throwable) {
        println(throwable.localizedMessage)
    }

    fun handleAppTheme(isChecked: Boolean) = if (isChecked) setNightModeOn() else setNightModeOff()

    private fun setNightModeOn() {
        AppPreferences.isNightModeEnabled = true
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }


    private fun setNightModeOff() {
        AppPreferences.isNightModeEnabled = false
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


}