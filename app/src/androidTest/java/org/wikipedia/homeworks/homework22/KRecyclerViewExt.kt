package org.wikipedia.homeworks.homework22

import androidx.compose.ui.platform.isDebugInspectorInfoEnabled
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.wikipedia.homeworks.homework07.exploreScreen.topRead.TopReadBlockInnerItem
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework20.setName
import kotlin.math.min

inline fun <reified T : KRecyclerItem<*>> KRecyclerView.invokeById(
    index: Int,
    targetId: Int,
    blockName: String,
    limiter: Int,
    function: T.() -> Unit
) {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == index) {
                setName(recycler.getName().withParent("$index block of $blockName"))
                function()
            }
        }
    }
    throw AssertionError("Block with id not found")

}


inline fun <reified T : KRecyclerItem<*>> KRecyclerView.findByById(
    index: Int,
    targetId: Int,
    blockName: String,
    limiter: Int,
): T {
    val recycler = this
    var findBlockCounter = 0
    val max = min(limiter, getSize())
    for (i in 0 until max) {
        childAt<T>(i) {
            if (hasIdAction(targetId)) findBlockCounter++
            if (findBlockCounter == index) {
                setName(recycler.getName().withParent("$index block of $blockName"))
                return this
            }
        }
    }
    throw AssertionError("Block with id not found")
}
