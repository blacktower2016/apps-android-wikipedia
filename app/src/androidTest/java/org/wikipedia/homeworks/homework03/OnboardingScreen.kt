package org.wikipedia.homeworks.homework03

import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import org.wikipedia.views.AppTextView

val skipButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_skip_button",
    "onboarding_skip"
)

val continueButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_forward_button",
    "onboarding_continue"
)

val getStartedButton = listOf(
    MaterialButton::class.java,
    "fragment_onboarding_done_button",
    "onboarding_get_started"
)

val currentScreenIndicator = listOf(
    TabLayout::class.java,
    "view_onboarding_page_indicator"
)

val addEditLanguagesButton = listOf(
    MaterialButton::class.java,
    "addLanguageButton",
    "onboarding_multilingual_add_language_text"
)

val onboardingCentralImage = listOf(
    AppCompatImageView::class.java,
    "imageViewCentered"
)

val screenTitle = listOf(
    AppTextView::class.java,
    "primaryTextView"
)

val screenText = listOf(
    AppTextView::class.java,
    "secondaryTextView"
)

val languagesList = listOf(
    RecyclerView::class.java,
    "languagesList"
)
