package org.wikipedia.homeworks.homework21

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework20.OnboardingScreen
import org.wikipedia.homeworks.homework21.extensions.checkText
import org.wikipedia.homeworks.homework21.extensions.customClick
import org.wikipedia.homeworks.homework21.extensions.getText
import org.wikipedia.homeworks.homework21.extensions.hasAnyDrawable
import org.wikipedia.homeworks.homework21.extensions.noDrawable
import org.wikipedia.main.MainActivity

class Test20 : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        run {
            step("Check drawable") {
                OnboardingScreen.onboardingCentralImage.hasAnyDrawable()
            }
            step("Check no drawable") {
                OnboardingScreen.onboardingCentralImage.noDrawable()
            }
            step("Check text") {
                OnboardingScreen.skipButton.checkText("Skip")
            }
            val text = OnboardingScreen.skipButton.getText()
            println(text)
            step("custom click") {
                OnboardingScreen.skipButton.customClick()
            }
        }
    }

}
