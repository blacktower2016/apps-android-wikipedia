package org.wikipedia.homeworks.homework08.onboardingScreen.editLanguagesScreen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.R

class AddNewLanguageScreen : KScreen<AddNewLanguageScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val items = KRecyclerView(
        builder = {
            withId(R.id.languages_list_recycler)
        },
        itemTypeBuilder = {
            itemType(::LanguageWithSubtitleItem)
        }
    )
}
