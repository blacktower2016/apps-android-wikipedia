package org.wikipedia.homeworks.homework10

import com.kaspersky.components.kautomator.component.common.builders.UiViewSelector
import com.kaspersky.components.kautomator.component.common.views.UiView
import com.kaspersky.components.kautomator.component.scroll.UiScrollView
import com.kaspersky.components.kautomator.component.text.UiButton
import com.kaspersky.components.kautomator.component.text.UiTextView
import com.kaspersky.components.kautomator.screen.UiScreen

// Домашнее задание №10. Kautomator
//
//1. Задание выполняем в homeworks/homework10
//2. Установить Appium Inspector.
//3. Описать экраны онбординга через Appium Inspector и Kautomator.
//4. Написать тесты для экрана онбординга, связанные с переключением
// между слайдами и проверкой элементов на соответствие
// фрагменту текста (через containsText) - минимум 4 сценария.
//5. Задача повышенной сложности: написать сценарий добавления языка

object OnboardingUiScreen: UiScreen<OnboardingUiScreen>() {
    override val packageName: String = "org.wikipedia.alpha"

    val screenTitle = UiTextView {
        withId(this@OnboardingUiScreen.packageName,  "primaryTextView")
    }

    val subtitle = UiTextView {
        withId(this@OnboardingUiScreen.packageName, "secondaryTextView")
    }

    val image = UiView {
        withId(this@OnboardingUiScreen.packageName, "imageViewCentered")
    }

    val buttonContinue = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_forward_button")
    }

    val buttonSkip = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_skip_button")
    }

    val buttonGetStarted = UiButton {
        withId(this@OnboardingUiScreen.packageName, "fragment_onboarding_done_button")
    }

    val indicator = UiScrollView {
        withId(this@OnboardingUiScreen.packageName, "view_onboarding_page_indicator")
    }
}
