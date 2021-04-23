package com.balajiprabhu.weather_app.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.balajiprabhu.weather_app.databinding.ItemCityWeatherBinding
import com.balajiprabhu.weather_app.view.adapter.CommonViewHolder
import com.balajiprabhu.weather_app.view_model.HomeWeatherItemViewModel

class WeatherListAdapter() : RecyclerView.Adapter<CommonViewHolder>() {

    private val weatherItemList = mutableListOf<HomeWeatherItemViewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemCityWeatherBinding = ItemCityWeatherBinding.inflate(layoutInflater, parent,false)
        return CommonViewHolder(itemCityWeatherBinding)
    }

    override fun getItemCount(): Int {
        return weatherItemList.size
    }

    override fun onBindViewHolder(holder: CommonViewHolder, position: Int) = holder.bind(weatherItemList[position])

    fun setWeatherItemListData(weatherList:List<HomeWeatherItemViewModel>){
        weatherItemList.clear()
        weatherItemList.addAll(weatherList)
        notifyDataSetChanged()
    }

}


