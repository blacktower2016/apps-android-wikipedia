package org.wikipedia.homeworks.homework24

import io.github.kakaocup.kakao.web.KWebView
import org.wikipedia.R
import org.wikipedia.homeworks.homework20.HierarchyClass
import org.wikipedia.homeworks.homework20.NamedKScreen

object WebViewDsl: NamedKScreen<WebViewDsl>() {
    override val name = "WebViewScreen"
    override val layoutId = null
    override val viewClass = null

    val webView by lazy {
        KWebView {
            withId(R.id.page_web_view)
        }
    }

    val reference by lazy {
        webView.withXPath("//*[@id='References']")
    }
}
