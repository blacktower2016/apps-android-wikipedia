package org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class EditLanguageItem(matcher: Matcher<View>): KRecyclerItem<EditLanguageItem>(matcher) {
    val languageTitle = KTextView(matcher) {
        withId(R.id.wiki_language_title)
    }
}
