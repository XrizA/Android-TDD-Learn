package io.github.xriza

import android.content.Context

class Repository(val sharedPreferenceManager: ISharedPreferenceManager) {
    fun saveUserId(id: String) {
        sharedPreferenceManager.saveString("USER_ID", id)
    }
}