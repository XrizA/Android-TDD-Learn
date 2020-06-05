package io.github.xriza

import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceManager(override val context: Context) : ISharedPreferenceManager {

    private val sharedPreferenceKey = "USER_DATA"

    var sharedPreference: SharedPreferences

    init {
        sharedPreference = context.getSharedPreferences(sharedPreferenceKey, Context.MODE_PRIVATE)
    }

    override fun saveString(key: String, value: String) {
        sharedPreference.edit().putString(key, value).commit()
    }

    override fun getString(key: String): String? {
        return sharedPreference.getString(key, "")
    }

}