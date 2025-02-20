package org.wikipedia.homeworks.homework07.exploreScreen

import android.view.View
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class CustomizeFeedItem(matcher: Matcher<View>) : KRecyclerItem<CustomizeFeedItem>(matcher) {

    val customizeImage = KImageView(matcher) {
        withId(R.id.view_announcement_header_image)
    }

    val customizeText = KTextView(matcher) {
        withId(R.id.view_announcement_text)
    }

    val customizeButton = KButton(matcher) {
        withId(R.id.view_announcement_action_positive)
    }

    val gotItButton = KButton(matcher) {
        withId(R.id.view_announcement_action_negative)
    }

}
