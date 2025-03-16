package org.wikipedia.homeworks.homework13

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ArticleLinkPopupScreen: KScreen<ArticleLinkPopupScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val openInNewTabButton = KTextView {
        withId(R.id.link_preview_secondary_button)
    }

    val readArticleButton = KTextView {
        withId(R.id.link_preview_primary_button)
    }
}
