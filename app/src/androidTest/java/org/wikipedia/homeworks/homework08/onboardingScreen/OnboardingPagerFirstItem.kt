package org.wikipedia.homeworks.homework08.onboardingScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.tabs.KTabLayout
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboardingScreen.firstItem.LanguageListItem

class OnboardingPagerFirstItem(
    matcher: Matcher<View>
) : KViewPagerItem<OnboardingPagerFirstItem>(matcher) {

    val languagesList = KRecyclerView(
        parent = matcher,
        builder = { withId(R.id.languagesList) },
//        builder = { withId(R.id.languageListContainer) },
        itemTypeBuilder = {
            itemType(::LanguageListItem)
        }
    )

    val addEditLanguagesButton = KButton(matcher) {
        withId(R.id.addLanguageButton)
    }


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
