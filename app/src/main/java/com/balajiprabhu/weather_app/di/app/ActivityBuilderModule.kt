package com.balajiprabhu.weather_app.di.app

import com.balajiprabhu.weather_app.di.home.HomeModule
import com.balajiprabhu.weather_app.di.home.HomeScope
import com.balajiprabhu.weather_app.di.home.HomeViewModelModule
import com.balajiprabhu.weather_app.view.home.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @HomeScope
    @ContributesAndroidInjector(modules = [HomeViewModelModule::class,HomeModule::class])
    abstract fun contributesHomeActivity(): HomeActivity

}