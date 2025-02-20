package org.wikipedia.homeworks.homework07.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class FeaturedArticleItem(matcher: Matcher<View>) : KRecyclerItem<FeaturedArticleItem>(matcher) {
    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val articleImage = KImageView(matcher) {
        withId(R.id.articleImage)
    }

    val articleTitle = KTextView(matcher) {
        withId(R.id.articleTitle)
    }

    val articleDescription = KTextView(matcher) {
        withId(R.id.articleDescription)
    }

    val divider = KView(matcher) {
        withId(R.id.articleDivider)
    }

    val articleExtract = KTextView(matcher) {
        withId(R.id.articleExtract)
    }

    val footer = KButton(matcher) {
        withId(R.id.footerActionButton)
    }
}
