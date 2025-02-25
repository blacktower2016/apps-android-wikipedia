package org.wikipedia.homeworks.homework08.onboardingScreen.firstItem

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.Matcher

class LanguageListItem(matcher: Matcher<View>) : KRecyclerItem<LanguageListItem>(matcher), TextViewAssertions {
}
