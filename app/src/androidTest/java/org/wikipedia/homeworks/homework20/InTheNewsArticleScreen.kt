package org.wikipedia.homeworks.homework20

import androidx.appcompat.widget.AppCompatImageButton
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import org.hamcrest.CoreMatchers.`is`
import org.wikipedia.R

object InTheNewsArticleScreen:NamedKScreen<InTheNewsArticleScreen>() {
    override val name: String = "InTheNews Article Screen"
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val image by lazy {
        KImageView {
            withId(R.id.header_image_view)
        }.setName(withParent("image"))
    }

    val backButton by lazy {
        KButton {
            isDescendantOfA {
                withId(R.id.toolbar)
            }
            withClassName(`is` (AppCompatImageButton::class.java.name))
        }.setName(withParent("button back"))
    }

    val items by lazy {
        KRecyclerView (
            builder = { withId(R.id.news_story_items_recyclerview)},
            itemTypeBuilder = {
                itemType(::InTheNewsItemSimilarArticle)
            }
        ).setName(withParent("similar articles"))
    }

}
