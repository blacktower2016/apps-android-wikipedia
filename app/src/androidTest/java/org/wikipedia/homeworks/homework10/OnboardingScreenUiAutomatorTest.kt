package org.wikipedia.homeworks.homework10

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.kakao.common.utilities.getResourceString
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.main.MainActivity

class OnboardingScreenUiAutomatorTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFirstScreen() {
        run("Verify first screen elements are displayed") {
            step("Verify onboarding screen central image is present") {
                OnboardingUiScreen.image.isDisplayed()
            }

            step("Verify title") {
                OnboardingUiScreen.screenTitle.isDisplayed()
            }

            step("Verify language is displayed") {
                OnboardingFirstUiScreen.languagesList.isDisplayed()
            }

            step("Verify addEditLanguage button is displayed") {
                OnboardingFirstUiScreen.buttonAddEditLanguage.isDisplayed()
            }

        }
    }

    @Test
    fun verifyIndicators() {
        run("Verify Indicators") {
            step("Verify indicator") {
                OnboardingUiScreen.indicator.isDisplayed()

            }
        }
    }

    @Test
    fun verifyScreensButtons() {

        fun verifySkip() {
            with(OnboardingUiScreen.buttonSkip) {
                isDisplayed()
                containsText(getResourceString(R.string.onboarding_skip))
            }
        }

        fun verifyContinue() {
            with(OnboardingUiScreen.buttonContinue) {
                isDisplayed()
                containsText(getResourceString(R.string.onboarding_continue))
            }
        }

        run("Verify screens buttons") {

            for (i in 1..3) {
                step("Verify $i screen buttons") {
                    step("Verify skip button")
                    {
                        verifySkip()
                    }

                    step("Verify continue button")
                    {
                        verifyContinue()
                    }
                }

                step("switch to next screen") {
                    OnboardingUiScreen.buttonContinue.click()
                }
            }

            step("Verify 4 screen buttons") {
                step("Verify Get Started button")
                {
                    with(OnboardingUiScreen.buttonGetStarted) {
                        isDisplayed()
                        containsText(getResourceString(R.string.onboarding_get_started))
                    }
                }
            }
        }
    }

    @Test
    fun verifyEachScreenHasTitleAndText() {
        run("Each screen has title and text") {
            fun clickContinue() {
                step("switch to next screen") {
                    OnboardingUiScreen.buttonContinue.click()
                }
            }

            with(OnboardingUiScreen) {
                step("Verify 1st screen texts") {
                    step("Verify title")
                    {
                        OnboardingUiScreen.screenTitle.containsText(
                            getResourceString(R.string.onboarding_welcome_title_v2)
                        )
                    }

                    step("Verify subtitle")
                    {
                        OnboardingUiScreen.subtitle.containsText(
                            getResourceString(R.string.onboarding_multilingual_secondary_text)
                        )
                    }
                }

                clickContinue()

                step("Verify 2nd screen texts") {
                    step("Verify title")
                    {
                        OnboardingUiScreen.screenTitle.containsText(
                            getResourceString(R.string.onboarding_explore_title)
                        )
                    }

                    step("Verify subtitle")
                    {
                        OnboardingUiScreen.subtitle.containsText(
                            "Dive down the Wikipedia rabbit hole"
                        )
                    }
                }

                clickContinue()

                step("Verify 3rd screen texts") {
                    step("Verify title")
                    {
                        screenTitle.containsText(
                            getResourceString(R.string.onboarding_reading_list_sync_title)
                        )
                    }

                    step("Verify subtitle")
                    {
                        subtitle.containsText("You can make reading lists")
                    }
                }

                clickContinue()

                step("Verify 4th screen texts") {
                    step("Verify title")
                    {
                        screenTitle.containsText(getResourceString(R.string.onboarding_data_privacy_title))
                    }

                    step("Verify subtitle")
                    {
                        subtitle.containsText("We believe that you should not have")
                    }
                }
            }
        }
    }
}
