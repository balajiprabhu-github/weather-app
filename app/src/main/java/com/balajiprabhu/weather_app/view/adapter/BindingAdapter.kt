package com.balajiprabhu.weather_app.view.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.balajiprabhu.weather_app.R
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:loadIconUrl")
    fun loadWeatherIcon(view: View, iconCode: String) {
        val iconUrl = "http://openweathermap.org/img/w/$iconCode.png"
        val imageView: ImageView = view as ImageView
        Glide.with(view.context)
            .load(R.drawable.ic_night_mode)
            .into(imageView)
    }

}