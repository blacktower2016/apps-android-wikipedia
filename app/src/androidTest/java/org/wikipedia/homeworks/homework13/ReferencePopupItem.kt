package org.wikipedia.homeworks.homework13

import android.view.View
import io.github.kakaocup.kakao.pager2.KViewPagerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class ReferencePopupItem(matcher: Matcher<View>): KViewPagerItem<ReferencePopupItem>(matcher) {
    val referenceId = KTextView(matcher) {
        withId(R.id.reference_id)
    }

    val referenceText = KTextView(matcher) {
        withId(R.id.reference_text)
    }

    val referenceExtLink = KTextView(matcher) {
        withId(R.id.reference_ext_link)
    }
}
