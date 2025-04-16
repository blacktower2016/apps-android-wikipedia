package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import org.wikipedia.homeworks.homework21.customAssertions.CustomAssertion

fun BaseAssertions.checkText(text: String) {
    view.check(CustomAssertion(text))
}
