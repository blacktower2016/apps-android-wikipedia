package org.wikipedia.homeworks.homework09.article

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R

object ArticleWebViewScreen: KScreen<ArticleWebViewScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val pageWebView = KWebView {
        withId(R.id.page_web_view)
    }

    val title = KTextView {
        withId(R.id.articleTitle)
    }

    val gotItButton = KButton {
//        withId(R.id.buttonView)
        withText(R.string.onboarding_got_it)
    }
}
