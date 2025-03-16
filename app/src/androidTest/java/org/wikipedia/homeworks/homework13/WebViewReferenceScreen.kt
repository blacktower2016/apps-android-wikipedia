package org.wikipedia.homeworks.homework13

import androidx.test.espresso.matcher.ViewMatchers.withId
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.pager2.KViewPager2
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

object WebViewReferenceScreen : KScreen<WebViewReferenceScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val referenceTitleText = KTextView {
        withId(R.id.reference_title_text)
    }

    val referenceId = KTextView {
        withId(R.id.reference_id)
        isDisplayed()
    }

    val referenceText = KTextView {
        withId(R.id.reference_text)
        isDisplayed()
    }

    val referenceLink= KTextView {
        withId(R.id.reference_ext_link)
        isDisplayed()
    }

}
