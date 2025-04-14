package org.wikipedia.homeworks.homework20

import io.github.kakaocup.kakao.common.utilities.getResourceString
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework08.OnboardingScreen.withParent


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

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeWithDescendantText(
    textId: Int,
    function: T.() -> Unit
) {
    val item = this.childWith<T> {
        withDescendant {
            withText(textId)
        }
    }.setName(withParent("with text '${getResourceString(textId)}(id=$textId)'"))
    item.function()
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeWithDescendantText(
    text: String,
    function: T.() -> Unit
) {
    val item = this.childWith<T> {
        withDescendant {
            withText(text)
        }
    }.setName(withParent("with text '$text'"))
    item.function()
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.getWithIndex(position: Int) {
    val recycler = this
    return childAt<T>(position) {
        setName(recycler.getName().withParent("$position"))
    }
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.getWithDescendantText(text: String): T {
    val recycler = this
    return childWith<T> {
       withDescendant {
           withText(text)
       }
    }. setName(recycler.getName().withParent("with text $text"))
}

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.getWithDescendantText(textId: Int): T {
    val recycler = this
    return childWith<T> {
        withDescendant {
            withText(textId)
        }
    }. setName(recycler.getName().withParent("with text ${getResourceString(textId)}"))
}



//inline fun <reified T : KRecyclerItem<*>> KRecyclerItem<*>.setName(name: String): KRecyclerItem<*> {
//    this.getName().withParent(name)
//    return this
//}
