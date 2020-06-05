package io.github.xriza

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isDialog
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

@LargeTest
class RegisterTest {

    @Rule
    @JvmField
    var activityActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun rightPassword_should_startActivity() {
        inputRightRegisterData()
        // Click on the registration button
        onView(withId(R.id.send)).perform(click())
        // The registration is successful and leads to the Success page.
        onView(withText("註冊成功")).check(matches(isDisplayed()))
    }

    private fun inputRightRegisterData() {
        // Enter your account number
        onView(withId(R.id.loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())
        // Enter your password
        onView(withId(R.id.password)).perform(typeText("a111111111"), ViewActions.closeSoftKeyboard())
    }

    @Test
    fun wrongPassword_should_alert() {
        inputWrongRegisterData()
        // Click on the registration button
        onView(withId(R.id.send)).perform(click())
        // The registration is successful and leads to the Success page.
        onView(withText("錯誤"))
            .inRoot(isDialog())
            .check(matches(isDisplayed()))
    }

    private fun inputWrongRegisterData() {
        // Enter your account number
        onView(withId(R.id.loginId)).perform(typeText("a123456789"), ViewActions.closeSoftKeyboard())
        // Enter your password
        onView(withId(R.id.password)).perform(typeText("123"), ViewActions.closeSoftKeyboard())
    }
}