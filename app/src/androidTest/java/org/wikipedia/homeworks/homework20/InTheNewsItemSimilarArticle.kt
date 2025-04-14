package org.wikipedia.homeworks.homework20;

import android.view.View;
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView

import org.hamcrest.Matcher;
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent

class InTheNewsItemSimilarArticle(matcher:Matcher<View>): KRecyclerItem<InTheNewsItemSimilarArticle>(matcher) {
    val title by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_title)
        }.setName(withParent("title"))
    }

    val description by lazy {
        KTextView(matcher) {
            withId(R.id.view_list_card_item_subtitle)
        }.setName(withParent("description"))
    }
}
