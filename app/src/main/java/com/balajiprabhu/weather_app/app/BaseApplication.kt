package com.balajiprabhu.weather_app.app

import androidx.appcompat.app.AppCompatDelegate
import com.balajiprabhu.weather_app.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BaseApplication : DaggerApplication(){

    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)

        if (AppPreferences.isNightModeEnabled) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}