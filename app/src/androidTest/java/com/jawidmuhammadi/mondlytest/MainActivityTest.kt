package com.jawidmuhammadi.mondlytest

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule(order = 1)
    val rule = HiltAndroidRule(this)

    @get:Rule(order = 2)
    var composeRule = createComposeRule()

    @Test
    fun whenActivityLaunchedThenTitleIsDisplayed() {
        ActivityScenario.launch(MainActivity::class.java)

        composeRule.onNodeWithText("Mondly by Pearson").assertIsDisplayed()
    }

    @Test
    fun whenActivityLaunchedThenFirstCardIsShownCorrectly() {
        ActivityScenario.launch(MainActivity::class.java)

        composeRule.onNodeWithText("name1").assertIsDisplayed()
        composeRule.onNodeWithText("description1").assertIsDisplayed()
    }

    @Test
    fun whenActivityLaunchedThenScrollTo9thProduct() {
        ActivityScenario.launch(MainActivity::class.java)

        composeRule.onNodeWithTag("product_lazy_grid")
            .performScrollToIndex(9)
            .assertIsDisplayed()
    }
}