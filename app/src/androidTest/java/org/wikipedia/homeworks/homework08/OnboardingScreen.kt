package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFourthItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerMiddleItem

object OnboardingScreen : KScreen<OnboardingScreen>() {

    override val layoutId = null
    override val viewClass = null

    // TODO 2. Описать экран Onboarding по всем правилам (слайды экрана в пейджере KViewPager2,
    //  аналогично ресайклеру), список языков в ресайклере.
    val slider = KViewPager2(
        builder = {
            withId(R.id.fragment_pager)
        },
        itemTypeBuilder = {
            itemType(::OnboardingPagerFirstItem)
            itemType(::OnboardingPagerMiddleItem)
            itemType(::OnboardingPagerFourthItem)
        }
    )

    // all except last
    val skipButton = KButton {
        withId(R.id.fragment_onboarding_skip_button)
    }

    // all except last
    val continueButton = KButton {
        withId(R.id.fragment_onboarding_forward_button)
    }

    // last page
    val getStartedButton = KButton {
        withId(R.id.fragment_onboarding_done_button)
    }
}
