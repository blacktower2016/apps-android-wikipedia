package org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen

import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R
import org.wikipedia.homeworks.homework08.OnboardingScreen

class EditLanguagesScreen : KScreen<OnboardingScreen>() {

    override val layoutId = null
    override val viewClass = null

    val buttonBack = KButton {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatImageButton::class.java)
    }

    val title = KTextView {
        isDescendantOfA {
            withId(R.id.toolbar)
        }
        isInstanceOf(AppCompatTextView::class.java)
    }

    val items = KRecyclerView(
        builder = {
            withId(R.id.wikipedia_languages_recycler)
        },
        itemTypeBuilder = {
            itemType(::EditLanguageItem)
            itemType(::AddLanguageButtonItem)
        }
    )
}
