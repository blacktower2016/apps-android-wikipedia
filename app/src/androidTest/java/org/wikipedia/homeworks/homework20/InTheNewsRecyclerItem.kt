package org.wikipedia.homeworks.homework20

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent

class InTheNewsRecyclerItem(matcher: Matcher<View>) : KRecyclerItem<InTheNewsItem>(matcher) {
    val image by lazy {
        KImageView(matcher) {
            withId(R.id.horizontal_scroll_list_item_image)
        }.setName(withParent("image"))
    }

    val text by lazy {
        KTextView(matcher) {
            withId(R.id.horizontal_scroll_list_item_text)
        }.setName(withParent("text"))
    }
}
