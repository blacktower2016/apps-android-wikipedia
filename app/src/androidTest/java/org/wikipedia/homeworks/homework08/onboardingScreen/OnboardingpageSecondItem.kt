package org.wikipedia.homeworks.homework08.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerSecondItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerSecondItem>(matcher) {

    // all except last screen
    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    // all except last
    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    // all screens
    val currentScreenIndicator = KTabLayout {
        withId(R.id.view_onboarding_page_indicator)
    }

    // all screens
    val screenTitle = KTextView {
        withId(R.id.primaryTextView)
    }

    // all screens
    val screenText = KTextView {
        withId(R.id.secondaryTextView)
    }
}
