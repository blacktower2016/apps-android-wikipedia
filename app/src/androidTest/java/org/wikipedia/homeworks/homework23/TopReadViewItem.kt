package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher
import org.hamcrest.Matchers.equalTo
import org.wikipedia.feed.topread.TopReadCardView
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent
import org.wikipedia.homeworks.homework20.setName

class TopReadViewItem(matcher: Matcher<View>) : KRecyclerItem<TopReadViewItem>(matcher) {
    val topReadWidget by lazy {
        TopReadWidget(matcher) {
            withClassName(equalTo(TopReadCardView::class.java.name))
        }.setName(withParent("Top Read widget"))
    }
}
