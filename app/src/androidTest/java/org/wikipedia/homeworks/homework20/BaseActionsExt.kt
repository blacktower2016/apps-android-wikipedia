package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions

val names = mutableMapOf<BaseActions, HierarchyClass>()

fun <T: BaseActions> T.setName(hierarchyClass: HierarchyClass): T {
    names[this] = hierarchyClass
    return this as T
}

fun BaseActions.getName(): HierarchyClass {
    return names[this] ?: throw NoSuchFieldException("No label")
}


//fun <T: BaseActions> T.withParent(name: String): T {
//    this.getName().withParent(name)
//    return this as T
//}
