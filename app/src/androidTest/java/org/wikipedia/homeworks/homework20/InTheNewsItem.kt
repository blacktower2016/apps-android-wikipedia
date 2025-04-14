package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent
import org.wikipedia.homeworks.homework20.InTheNewsRecyclerItem

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {

    val header by lazy {
        KTextView(matcher) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Header"))
    }

    val headerMenu by lazy {
        KImageView(matcher) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("header menu"))
    }

    val items by lazy {
        KRecyclerView(
            parent = matcher,
            builder = {
                withId(R.id.news_cardview_recycler_view)
            },

            itemTypeBuilder = {
                itemType(::InTheNewsRecyclerItem)
            }
        ).setName(withParent("In the news block"))
    }
}
