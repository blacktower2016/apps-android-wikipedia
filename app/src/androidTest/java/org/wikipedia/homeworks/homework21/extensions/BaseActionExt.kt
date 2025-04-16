package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.common.actions.BaseActions
import org.wikipedia.homeworks.homework21.customActions.CustomViewAction
import org.wikipedia.homeworks.homework21.customActions.GetText

fun BaseActions.customClick() {
    view.perform(CustomViewAction())
}

fun BaseActions.getText(): String {
    val text = GetText()
    view.perform(text)
    return text.getText()
}
