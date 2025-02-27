package org.wikipedia.homeworks.homework09

import androidx.appcompat.widget.AppCompatImageButton
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.CoreMatchers.`is`
import org.wikipedia.R

object InTheNewsArticleScreen:KScreen<InTheNewsArticleScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val image = KImageView {
        withId(R.id.header_image_view)
    }

    val backButton = KButton {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        withClassName(`is` (AppCompatImageButton::class.java.name))
    }

    val items = KRecyclerView (
        builder = { withId(R.id.news_story_items_recyclerview)},
        itemTypeBuilder = {
            itemType(::InTheNewsItemSimilarArticle)
        }
    )

}
