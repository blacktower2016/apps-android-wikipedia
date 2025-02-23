package org.wikipedia.homeworks.homework08

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFirstItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerFourthItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerSecondItem
import org.wikipedia.homeworks.homework08.onboardingScreen.OnboardingPagerThirdItem

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
            itemType(::OnboardingPagerSecondItem)
            itemType(::OnboardingPagerThirdItem)
            itemType(::OnboardingPagerFourthItem)
        }
    )
}
