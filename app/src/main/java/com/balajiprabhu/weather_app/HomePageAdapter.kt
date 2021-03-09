package com.balajiprabhu.weather_app

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class HomePageAdapter(fragmentManager: FragmentManager):FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentTileList = mutableListOf<String>()

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentTileList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTileList[position]
    }

    fun addFragment(fragment: Fragment,title:String){
        fragmentList.add(fragment)
        fragmentTileList.add(title)
    }

}