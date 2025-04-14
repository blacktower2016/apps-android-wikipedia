package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.inTheNews.InTheNewsRecyclerItem
import org.wikipedia.homeworks.homework20.setName
import org.wikipedia.homeworks.homework20.withParent

class InTheNewsItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {

    val header = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }.setName(withParent("Header"))

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
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
