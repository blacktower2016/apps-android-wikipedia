package org.wikipedia.homeworks.homework07

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.DateItem
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem
import org.wikipedia.homeworks.homework07.exploreScreen.SearchCardViewItem
import org.wikipedia.homeworks.homework07.exploreScreen.TopReadItem


object ExploreScreen : KScreen<ExploreScreen>() {
    override val layoutId = null
    override val viewClass = null

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.feed_view)
        },
        itemTypeBuilder = {
            itemType(::SearchCardViewItem)
            itemType(::TopReadItem)
            itemType(::FeaturedArticleItem)
            itemType(::InTheNewsItem)
            itemType(::DateItem)

        }
    )
}
