package org.wikipedia.homeworks.hw08

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.SearchCardViewItem
import org.wikipedia.homeworks.homework07.exploreScreen.TopReadItem
import org.wikipedia.homeworks.homework07.exploreScreen.topRead.TopReadBlockInnerItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.main.MainActivity

class ExploreScreenTests : TestCase() {

    // THIS IS EXAMPLE FORM THE LESSON

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleTest() {
        run {
            step("Skipping") {
                OnboardingScreen.skipButton.click()
            }
            step("Проверяет отображение тулбара") {
                ExploreScreen.toolbarTitle.isDisplayed()
            }
            step("Checking logo of mic in search") {
                ExploreScreen.items.childAt<SearchCardViewItem>(0) {
                    voiceIcon.isDisplayed()
                }
            }
            step("Checking has logo in 2nd child in topRead") {
                ExploreScreen.items.childAt<TopReadItem>(4) {
                    step("TopReadCardViewItem.isDisplayed()") {
                        isDisplayed()
                    }

                    items.childAt<TopReadBlockInnerItem>(1) {
                        isDisplayed()
                        image.isDisplayed()
                    }
                }
            }
        }
    }
}
