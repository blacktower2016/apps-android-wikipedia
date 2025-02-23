package org.wikipedia.homeworks.homework08.onboardingScreen.firstItem

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageListItem(matcher: Matcher<View>) : KRecyclerItem<LanguageListItem>(matcher) {
    // TODO: why it doesn't work with this matcher??
//    val label = KTextView(matcher) {
//        println(matcher)
//        withId(R.id.option_label)
//    }

    val label = KTextView {
        withId(R.id.option_label)
    }
}
