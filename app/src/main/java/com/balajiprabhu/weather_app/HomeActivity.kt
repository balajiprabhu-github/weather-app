package com.balajiprabhu.weather_app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.balajiprabhu.weather_app.databinding.ActivityHomeBinding
import com.balajiprabhu.weather_app.view_model.HomeWeatherViewModel


class HomeActivity : AppCompatActivity() {

    private val homeViewModel = HomeWeatherViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        activityMainBinding.viewModel = homeViewModel
    }
}