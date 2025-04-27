package org.wikipedia.homeworks.homework23

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.OnboardingScreen.skipButton
import org.wikipedia.homeworks.homework20.steps
import org.wikipedia.main.MainActivity

class WidgetTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)



    @Test
    fun testWidget() {
        run {
            steps {
                click(skipButton)
                ExploreScreenWithWidget.searchWidget {
//                    isDisplayed(searchIcon)
                    isDisplayed(voiceIcon)
                    isDisplayed(searchText)
                }
                ExploreScreenWithWidget.items.childWith<TopReadViewItem> {
                    withText("Top read")
                }.topReadWidget{
                    isDisplayed(headerTitle)
                }
            }
        }
    }
}
