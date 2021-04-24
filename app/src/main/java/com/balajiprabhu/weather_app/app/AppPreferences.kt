package com.balajiprabhu.weather_app.app

import android.content.Context
import android.content.SharedPreferences

object AppPreferences {

    private const val NAME = "WeatherApp"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    // list of app specific preferences
    private val IS_NIGHT_MODE_ENABLED = Pair("is_night_mode_enabled", false)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation:
                                                  (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isNightModeEnabled: Boolean
        // custom getter to get a preference of a desired type, with a predefined default value
        get() = preferences.getBoolean(IS_NIGHT_MODE_ENABLED.first, IS_NIGHT_MODE_ENABLED.second)

        // custom setter to save a preference back to preferences file
        set(value) = preferences.edit {
            it.putBoolean(IS_NIGHT_MODE_ENABLED.first, value)
        }
}