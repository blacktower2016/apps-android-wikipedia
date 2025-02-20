package org.wikipedia.homeworks.homework07.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.topRead.TopReadBlockInnerItem

class TopReadItem(matcher: Matcher<View>) : KRecyclerItem<View>(matcher) {
    val headerTitle = KTextView(matcher) {
        withId(R.id.view_card_header_title)
    }

    val headerMenu = KImageView(matcher) {
        withId(R.id.view_list_card_header_menu)
    }

    val footer = KButton(matcher) {
        withId(R.id.footerActionButton)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.view_list_card_list)
        },
        itemTypeBuilder = {
            itemType(::TopReadBlockInnerItem)
        }
    )

}
