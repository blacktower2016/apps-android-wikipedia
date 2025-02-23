package org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class LanguageWithSubtitleItem(matcher: Matcher<View>) : KRecyclerItem<LanguageWithSubtitleItem>(matcher) {
    val localizedName = KTextView(matcher) {
        withId(R.id.localized_language_name)
    }

    val languageSubtitle = KTextView(matcher) {
        withId(R.id.language_subtitle)
    }
}
