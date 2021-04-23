package com.balajiprabhu.weather_app.view.home

import android.os.Bundle
import androidx.databinding.CallbackRegistry
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import com.balajiprabhu.weather_app.R
import com.balajiprabhu.weather_app.databinding.ActivityHomeBinding
import com.balajiprabhu.weather_app.view_model.HomeWeatherViewModel
import dagger.android.DaggerActivity
import javax.inject.Inject

class HomeActivity : DaggerActivity(),LifecycleOwner {

    lateinit var lifecycleRegistry: LifecycleRegistry

    @Inject
    lateinit var homeViewModel : HomeWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        activityMainBinding.viewModel = homeViewModel

        lifecycleRegistry = LifecycleRegistry(this)
        lifecycle.addObserver(homeViewModel)
    }

    override fun getLifecycle(): Lifecycle = lifecycleRegistry

}