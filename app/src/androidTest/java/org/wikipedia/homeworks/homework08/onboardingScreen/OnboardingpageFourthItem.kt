package org.wikipedia.homeworks.homework08.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class OnboardingPagerFourthItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFourthItem>(matcher) {

    val image = KImageView(matcher) {
        withId(R.id.imageViewCentered)
    }

    // all screens
    val currentScreenIndicator = KTabLayout(matcher) {
        withId(R.id.view_onboarding_page_indicator)
    }

    // all screens
    val screenTitle = KTextView(matcher) {
        withId(R.id.primaryTextView)
    }

    // all screens
    val screenText = KTextView(matcher) {
        withId(R.id.secondaryTextView)
    }


}
