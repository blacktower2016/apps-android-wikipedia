package org.wikipedia.homeworks.homework23

import android.view.View

import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent
import org.wikipedia.homeworks.homework20.setName

class SearchWidget: KWidget<SearchWidget> {
    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)
    constructor(function: ViewBuilder.() -> Unit) : super(function)

    val searchIcon by lazy {
        KImageView(parent) {
            withDrawable(R.drawable.ic_search_white_24dp)
        }.setName(withParent("Search Icon"))
    }

    val searchText by lazy {
        KTextView(parent) {
            withText(R.string.search_hint)
        }.setName(withParent("Search text field"))
    }

    val voiceIcon by lazy {
        KImageView(parent) {
            withId(R.id.voice_search_button)
        }.setName(withParent("Voice search icon"))
    }
}
