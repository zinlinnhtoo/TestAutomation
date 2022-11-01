package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.activities.MainActivity
import org.junit.Before
import org.junit.Test
import com.zg.burgerjoint.R
import com.zg.burgerjoint.viewholders.BurgerViewHolder

class GoToBurgerDetailTest {
    private val activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        activityRule.launchActivity(Intent())
    }

    @Test
    fun tapOnBurger_navigateToBurgerDetails() {
        onView(withId(R.id.rvBurgerList)).perform(
            RecyclerViewActions.actionOnItemAtPosition<BurgerViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
    }
}