package org.wikipedia.homeworks.homework20

import androidx.compose.ui.test.hasText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.DateItem
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.exploreScreen.SearchCardViewItem


object ExploreScreen : NamedKScreen<ExploreScreen>() {
    override val name: String = "Explore Screen"
    override val layoutId = null
    override val viewClass = null

    val toolbarTitle = KImageView {
        withId(R.id.main_toolbar_wordmark)
    }.setName(withParent("Tool bar title"))

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
    ).setName(withParent("Explore screen recycler"))

    fun topReadItem(index: Int, function: TopReadItem.() -> Unit): Unit {
        return items.invokeAtIndex<TopReadItem>(index, function)
    }

    fun topReadItem(): TopReadItem {
        return items.childWith<TopReadItem> {
            withDescendant {
                hasText("Top Read")
            }
        }.setName(items.getName().withParent("Top Read"))
    }
}
