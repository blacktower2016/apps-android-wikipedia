package org.wikipedia.homeworks.homework23

import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.ExploreScreen
import org.wikipedia.homeworks.homework20.NamedKScreen
import org.wikipedia.homeworks.homework20.setName

object ExploreScreenWithWidget : NamedKScreen<ExploreScreenWithWidget>() {
    override val name = "ExploreScreen"
    override val layoutId = null
    override val viewClass = null

    val searchWidget by lazy {
        SearchWidget {
            withId(R.id.search_container)
        }.setName(withParent("Виджет поиска"))
    }

    val items by lazy {
        KRecyclerView(
            builder = {
                withId(R.id.feed_view)
            },
            itemTypeBuilder = {
                itemType(::TopReadViewItem)
//                itemType(_root_ide_package_.org.wikipedia.homeworks.homework07.exploreScreen::FeaturedArticleItem)
//                itemType(_root_ide_package_.org.wikipedia.homeworks.homework20::InTheNewsItem)
//                itemType(_root_ide_package_.org.wikipedia.homeworks.homework07.exploreScreen::DateItem)

            }
        ).setName(ExploreScreen.withParent("Explore screen recycler"))
    }
}
