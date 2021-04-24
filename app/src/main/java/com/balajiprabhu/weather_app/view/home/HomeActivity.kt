package com.balajiprabhu.weather_app.view.home

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import com.balajiprabhu.weather_app.R
import com.balajiprabhu.weather_app.databinding.ActivityHomeBinding
import com.balajiprabhu.weather_app.view_model.HomeWeatherViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var homeViewModel: HomeWeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        activityMainBinding.viewModel = homeViewModel
        lifecycle.addObserver(homeViewModel)
    }
}