package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KButton
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFourthItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerMiddleItem

object OnboardingScreen : NamedKScreen<OnboardingScreen>() {
    override val name = "Onboarding screen"

    override val layoutId = null
    override val viewClass = null

    // TODO 2. Описать экран Onboarding по всем правилам (слайды экрана в пейджере KViewPager2,
    //  аналогично ресайклеру), список языков в ресайклере.
    val slider by lazy {
        KViewPager2(
            builder = {
                withId(R.id.fragment_pager)
            },
            itemTypeBuilder = {
                itemType(::OnboardingPagerFirstItem)
                itemType(::OnboardingPagerMiddleItem)
                itemType(::OnboardingPagerFourthItem)
            }
        ).setName(withParent("slider"))
    }

    // all except last
    val skipButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_skip_button)
        }.setName(withParent("button 'Skip'"))
    }

    // all except last
    val continueButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_forward_button)
        }.setName(withParent("continue button"))
    }

    // last page
    val getStartedButton by lazy {
        KButton {
            withId(R.id.fragment_onboarding_done_button)
        }.setName(withParent("get started button"))
    }
}
