package com.picpay.desafio.android.presentation.fragment

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.picpay.desafio.android.R
import com.picpay.desafio.android.presentation.MainActivity
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test

class MainFragmentScreenTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun shouldPassWhenHeaderIsVisible() {
        val linearLayout = Espresso.onView(
            Matchers.allOf(
                withId(R.id.include_header),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(R.id.container))),
                isDisplayed()
            )
        )
        linearLayout.check(matches(isDisplayed()))
    }

    @Test
    fun shouldPassWhenLogoViewHasVisible() {
        Espresso.onView(withId(R.id.image_logo))
            .check(matches(isDisplayed()))
    }


    @Test
    fun shouldPassWhenRecyclerIsVisible() {
        Thread.sleep(5000)
        Espresso.onView(withId(R.id.recyclerView))
            .perform()
            .check(matches(isDisplayed()))
    }

}