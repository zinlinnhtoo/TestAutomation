package com.zg.burgerjoint.uitests.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.activities.LoginActivity
import com.zg.burgerjoint.R
import org.junit.Before
import org.junit.Test

class LoginSuccessTest {
    private val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Before
    fun setUp() {
        activityRule.launchActivity(Intent())
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.btnLogin)).check(matches(isDisplayed()))
    }

    @Test
    fun enterInformation_navigationToBurgerListScreen() {
        onView(withId(R.id.etUserName)).perform(
            typeText(
                TEST_USER_NAME
            ), closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            typeText(
                TEST_PASSWORD
            ), closeSoftKeyboard()
        )

        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.rvBurgerList)).check(matches(isDisplayed()))
    }
}

private val TEST_USER_NAME = "Saw Rabin"
private val TEST_PASSWORD = "1234"