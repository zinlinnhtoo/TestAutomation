package com.zg.burgerjoint.uitests.burgerlist

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.zg.burgerjoint.activities.MainActivity
import org.junit.Before
import org.junit.Test
import com.zg.burgerjoint.R


class PlayGameTest {
    private val activityRule=ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp(){
        activityRule.launchActivity(Intent())
    }

    @Test
    fun tapOnPlayGames_navigateToPlayGames(){
        onView(withId(R.id.btnPlayGame)).perform(click())
        onView(withId(R.id.ivGameBurger)).check(matches(isDisplayed()))
    }
}