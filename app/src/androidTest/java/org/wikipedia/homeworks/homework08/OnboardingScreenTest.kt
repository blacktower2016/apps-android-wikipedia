package org.wikipedia.homeworks.homework08

import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerSecondItem
import org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen.AddLanguageButtonItem
import org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen.AddNewLanguageScreen
import org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen.EditLanguageItem
import org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen.EditLanguagesScreen
import org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen.LanguageWithSubtitleItem
import org.wikipedia.homeworks.homework08.onboardingScreen.firstItem.LanguageListItem
import org.wikipedia.main.MainActivity
import java.lang.Thread.sleep

class OnboardingScreenTest : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun englishIsPresentInLanguageListTest() {
        run {
            step("Check first item of language list") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    languagesList {
                        step("language list is visible") {
                            isVisible()
                        }
                        firstChild<LanguageListItem> {
                            step("first child is visible") {
                                label.isVisible()
                            }
                            step("Contains text") {
                                label.containsText("English")
                            }
                        }
                    }
                }
            }
        }

    }

    @Test
    fun centralImageIsVisibleTest() {
        run {
            step("Check central image is visible") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    image.isVisible()
                }
            }
        }
    }

    @Test
    fun pageSwitchTest() {
        run {
            step("Click 'Continue' button") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    continueButton.click()
                }
                sleep(2)
            }
            step("Verify that second screen is displayed") {
                OnboardingScreen.slider.childAt<OnboardingPagerSecondItem>(1) {
                    isVisible()
                }
            }
        }
    }

    @Test
    fun titleTextTest() {
        run {
            step("Verify title text") {
                OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                    screenTitle.hasText(R.string.onboarding_welcome_title_v2)
                }
            }
        }
    }

    @Test
    fun addLanguageTest() {
        run {
            OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                step("Check that there is one item in language list") {
                    languagesList.isVisible()
                    languagesList.hasSize(1)
                }
                step("Click Add Language button") {
                    addEditLanguagesButton.click()
                }
            }

            with(EditLanguagesScreen()) {
                step("Check screen title") {
                    title.hasText("Wikipedia languages")
                }
                step("Verify that first language in list is English") {
                    items.childAt<EditLanguageItem>(0) {
                        hasText("English")
                    }
                }
                step("Click 'Add language' button") {
                    items.children<AddLanguageButtonItem> {
                        click()
                    }
                }
            }

            with(AddNewLanguageScreen()) {
                step("Select Russian") {
                    items.childAt<LanguageWithSubtitleItem>(2) {
                        // todo: how to select by text ??
                        click()
                    }
                }
            }

            with(EditLanguagesScreen()) {
                step("Click back") {
                    buttonBack.click()
                }
            }

            OnboardingScreen.slider.childAt<OnboardingPagerFirstItem>(0) {
                step("Check list size") {
                    languagesList.hasSize(2)
                }
                step("Check first language in list is English") {
                    languagesList.firstChild<LanguageListItem> {
                        hasText("English")
                    }
                }
                step("Check last language in list is Russian") {
                    languagesList.lastChild<LanguageListItem> {
                        hasText("Русский")
                    }
                }
            }

        }

    }
}
