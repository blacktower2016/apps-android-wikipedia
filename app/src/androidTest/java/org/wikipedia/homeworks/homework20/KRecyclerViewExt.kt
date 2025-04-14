package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.actions.BaseActions
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView


inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeAtIndex(
    position: Int,
    function: T.() -> Unit
) {
    val recycler = this
    childAt<T>(position) {
        setName(recycler.getName().withParent("$position"))
        function()
    }

}

fun KRecyclerView.setName(name: String): KRecyclerView {
    this.getName().withParent(name)
    return this
}


inline fun <reified T : KRecyclerItem<*>> KRecyclerItem<*>.setName(name: String): KRecyclerItem<*> {
    this.getName().withParent(name)
    return this
}
