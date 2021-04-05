package com.balajiprabhu.weather_app.view

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.balajiprabhu.weather_app.BR

class CommonViewHolder(private val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    fun <VM> bind(viewModel: VM){
        viewDataBinding.setVariable(BR.viewModel,viewModel)
        viewDataBinding.executePendingBindings()
    }

}