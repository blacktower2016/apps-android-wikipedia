package org.wikipedia.homeworks.homework07.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class DateItem(matcher: Matcher<View>) : KRecyclerItem<DateItem>(matcher) {
    val dateText = KTextView(matcher) {
        withId(R.id.day_header_text)
    }
}
