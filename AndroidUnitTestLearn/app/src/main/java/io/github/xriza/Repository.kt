package io.github.xriza

class Repository(val sharedPreferenceManager: ISharedPreferenceManager) {
    fun saveUserId(id: String) {
        sharedPreferenceManager.saveString("USER_ID", id)
    }
}