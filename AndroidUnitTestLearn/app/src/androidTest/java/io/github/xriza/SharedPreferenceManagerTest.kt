package io.github.xriza

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SharedPreferenceManagerTest {
    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val key = "User_Id"
        val value = "A123456789"

        val sharedPreferenceManager: ISharedPreferenceManager = SharedPreferenceManager(appContext)
        sharedPreferenceManager.saveString(key, value)

        val valueFromSP = sharedPreferenceManager.getString(key)

        Assert.assertEquals(value, valueFromSP)
    }
}