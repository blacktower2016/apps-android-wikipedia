package org.wikipedia.homeworks.homework10

import androidx.test.uiautomator.UiSelector
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

object OnboardingFirstUiScreen : UiScreen<OnboardingFirstUiScreen>() {

    override val packageName: String = "org.wikipedia.alpha"


    val buttonAddEditLanguage = UiButton {
        withId(this@OnboardingFirstUiScreen.packageName, "addLanguageButton")
    }


    val languagesList = UiScrollView {
        withId(this@OnboardingFirstUiScreen.packageName, "languagesList")
    }

    val options = {
        // TODO: how??
    }
}

