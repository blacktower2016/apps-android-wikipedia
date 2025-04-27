package org.wikipedia.homeworks.homework23

import android.view.View
import io.github.kakaocup.kakao.common.builders.ViewBuilder
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.topRead.TopReadBlockInnerItem
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent
import org.wikipedia.homeworks.homework20.setName

class TopReadWidget: KWidget<TopReadWidget> {

    constructor(matcher: Matcher<View>, function: ViewBuilder.() -> Unit) : super(matcher, function)
    constructor(function: ViewBuilder.() -> Unit) : super(function)

    val headerTitle by lazy {
        KTextView(parent) {
            withId(R.id.view_card_header_title)
        }.setName(withParent("Header title"))
    }

    val headerMenu by lazy {
        KImageView(parent) {
            withId(R.id.view_list_card_header_menu)
        }.setName(withParent("header menu"))
    }

    val footer by lazy {
        KButton(parent) {  // or KTextView?
            withId(R.id.footerActionButton)
        }.setName(withParent("footer"))
    }

    val items by lazy {
        KRecyclerView(
            parent = parent,
            builder = {
                withId(R.id.view_list_card_list)
            },
            itemTypeBuilder = {
                itemType(::TopReadBlockInnerItem)
            }
        ).setName(withParent("top read block"))
    }
}
