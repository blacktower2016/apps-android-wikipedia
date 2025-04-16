package org.wikipedia.homeworks.homework21.extensions

import io.github.kakaocup.kakao.image.ImageViewAssertions
import org.wikipedia.homeworks.homework21.customAssertions.HasDrawableAssertion
import org.wikipedia.homeworks.homework21.customAssertions.HasNoDrawableAssertion

fun ImageViewAssertions.hasAnyDrawable() {
    view.check(HasDrawableAssertion())
}

fun ImageViewAssertions.noDrawable() {
    view.check(HasNoDrawableAssertion())
}
