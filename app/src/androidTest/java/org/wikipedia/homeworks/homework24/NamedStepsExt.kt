package org.wikipedia.homeworks.homework24

import org.wikipedia.homeworks.homework20.NamedSteps

fun NamedSteps.scroll(item: KWebViewElement) {
    testContext.step("Scroll '${item. name}'") {
        testContext. flakySafely( 150000) {
            item. executeAction { scroll() }
        }
    }
}
