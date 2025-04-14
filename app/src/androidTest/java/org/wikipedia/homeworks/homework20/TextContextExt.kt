package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val stepMap = mutableMapOf<TestContext<*>, NamedSteps>()

val TestContext<*>.steps: NamedSteps
    get() {
        return stepMap.getOrPut(this) {
            NamedSteps(this)
        }
    }
