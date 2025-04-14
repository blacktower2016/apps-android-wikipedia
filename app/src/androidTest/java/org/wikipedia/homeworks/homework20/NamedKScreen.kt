package org.wikipedia.homeworks.homework20

import com.kaspersky.kaspresso.screens.KScreen

abstract class NamedKScreen<out T : KScreen<T>> : KScreen<T>() {
    abstract val name: String
    val hierarchyClass by lazy { HierarchyClass(name) }

    fun withParent(name: String): HierarchyClass {
        return hierarchyClass.withParent(name)
    }
}
