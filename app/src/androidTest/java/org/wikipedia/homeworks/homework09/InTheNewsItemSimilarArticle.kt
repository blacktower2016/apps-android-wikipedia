package org.wikipedia.homeworks.homework09;

import android.view.View;
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView

import org.hamcrest.Matcher;
import org.wikipedia.R

class InTheNewsItemSimilarArticle(matcher:Matcher<View>): KRecyclerItem<InTheNewsItemSimilarArticle>(matcher) {
    val title = KTextView(matcher) {
        withId(R.id.view_list_card_item_title)
    }

    val description = KTextView(matcher) {
        withId(R.id.view_list_card_item_subtitle)
    }
}
