package com.balajiprabhu.weather_app.di.app.mutlibinding

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun providesViewModel(viewModelProviderFactory: ViewModelProviderFactory):ViewModelProvider.Factory
}