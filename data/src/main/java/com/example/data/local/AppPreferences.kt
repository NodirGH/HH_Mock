package com.example.data.local

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class AppPreferences @Inject constructor(val context: Context) {

    private var preferences: SharedPreferences = context.getSharedPreferences("HHMockPreference", Context.MODE_PRIVATE)

    var isUserRegister: Boolean
    get() = preferences.getBoolean(::isUserRegister.name, false)
    set(value) {
        preferences.edit().putBoolean(::isUserRegister.name, value).apply()
    }
}