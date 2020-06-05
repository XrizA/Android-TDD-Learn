package io.github.xriza

import android.content.Context

interface ISharedPreferenceManager {
    val context: Context
    fun saveString(key: String, value: String)
    fun getString(key: String): String?
}