package com.balajiprabhu.weather_app.di.home

import androidx.lifecycle.ViewModel
import com.balajiprabhu.weather_app.di.app.mutlibinding.ViewModelKey
import com.balajiprabhu.weather_app.view_model.HomeWeatherViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeWeatherViewModel::class)
    abstract fun providesHomeViewModel(homeWeatherViewModel: HomeWeatherViewModel): ViewModel

}
