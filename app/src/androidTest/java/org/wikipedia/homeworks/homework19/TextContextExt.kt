package org.wikipedia.homeworks.homework19

import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepMap = mutableMapOf<TestContext<*>, Steps>()

val TestContext<*>.steps: Steps
    get() {
        return stepMap.getOrPut(this) {
            Steps(this)
        }
    }
