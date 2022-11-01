package com.zg.burgerjoint.uitests.login

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.R
import com.zg.burgerjoint.activities.LoginActivity
import com.zg.burgerjoint.utils.EM_LOGIN_FAIL_ERROR_MESSAGE
import org.junit.Before
import org.junit.Test

class LoginFailTest {
    private val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Before
    fun setUp() {
        activityRule.launchActivity(Intent())
    }

    @Test
    fun checkLoginButtonIsDisplayed() {
        onView(withId(R.id.btnLogin))
            .check(matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun enterInformation_showErrorMessage() {
        onView(withId(R.id.etUserName)).perform(
            ViewActions.typeText(
                TEST_USER_NAME_EMPTY
            ), ViewActions.closeSoftKeyboard()
        )
        onView(withId(R.id.etPassword)).perform(
            ViewActions.typeText(
                TEST_PASSWORD_EMPTY
            ), ViewActions.closeSoftKeyboard()
        )

        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(com.google.android.material.R.id.snackbar_text))
            .check(matches(withText(EM_LOGIN_FAIL_ERROR_MESSAGE)))
    }
}

private val TEST_USER_NAME_EMPTY = ""
private val TEST_PASSWORD_EMPTY = ""
