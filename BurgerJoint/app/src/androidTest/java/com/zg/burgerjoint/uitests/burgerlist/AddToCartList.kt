package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.activities.MainActivity
import org.junit.Before
import org.junit.Test
import com.zg.burgerjoint.R
import com.zg.burgerjoint.uitests.utils.first

class AddToCartList {
    private val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activityRule.launchActivity(Intent())
    }

    @Test
    fun onTapAddToCart_numberOfItemInCartIncrease() {
        onView(first<View>(withId(R.id.btnAddToCart))).perform(click())
        Thread.sleep(1000L)
        onView(withId(R.id.tvCartCount)).check(matches(withText("1")))
    }
}