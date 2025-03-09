package org.wikipedia.homeworks.homework09.article

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object ArticleWebViewScreen: KScreen<ArticleWebViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val pageWebView = KView {
        withId(R.id.page_web_view)
    }

    val title = KTextView {
        withId(R.id.articleTitle)
    }
}
