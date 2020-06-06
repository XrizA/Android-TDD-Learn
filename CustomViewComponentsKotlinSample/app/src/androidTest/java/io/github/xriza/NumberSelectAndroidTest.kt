package io.github.xriza

import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.number_select.view.*
import org.junit.Assert
import org.junit.Test

class NumberSelectAndroidTest {
    @Test
    fun testAddButtonThenValueShouldAdd() {

        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(1)
        numberSelect.addButton.performClick()

        assertEquals(2, numberSelect.textValue)
    }

    @Test
    fun testMinusButtonThenValueShouldMinus() {

        val context = InstrumentationRegistry.getInstrumentation().targetContext

        val numberSelect = NumberSelect(context)
        numberSelect.setDefaultValue(2)
        numberSelect.minusButton.performClick()

        assertEquals(1, numberSelect.textValue)
    }
}