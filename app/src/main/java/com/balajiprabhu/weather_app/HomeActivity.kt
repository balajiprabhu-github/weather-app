package com.balajiprabhu.weather_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val homePageAdapter = HomePageAdapter(supportFragmentManager)
        homePageAdapter.addFragment(ForeCastFragment(),"Search")
        homePageAdapter.addFragment(CityWeatherFragment(),"City")
        home_page_container.adapter = homePageAdapter
        home_page_tabs.setupWithViewPager(home_page_container)
    }
}