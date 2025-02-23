package org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen

import android.view.View
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher
import org.wikipedia.R

class AddLanguageButtonItem(matcher: Matcher<View>): KRecyclerItem<EditLanguageItem>(matcher) {

    val addLanguageButton = KTextView(matcher) {
        withText(R.string.wikipedia_languages_add_language_text)
    }
}
