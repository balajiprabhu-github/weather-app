package com.balajiprabhu.weather_app.view.adapter

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.balajiprabhu.weather_app.R
import com.bumptech.glide.Glide

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("android:loadIconUrl")
    fun setLoadIconUrl(view: View, iconCode: String) {
        val iconUrl = "http://openweathermap.org/img/wn/10d@2x.png"
        val imageView: ImageView = view as ImageView
        Glide.with(view.context)
            .load(R.drawable.ic_clear_sky_day)
            .into(imageView)

    }

}