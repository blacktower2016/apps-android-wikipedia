package org.wikipedia.homeworks.homework24

import androidx.test.espresso.web.webdriver.Locator
import io.github.kakaocup.kakao.web.KWebView
import io.github.kakaocup.kakao.web.WebElementBuilder.KWebInteraction
import org.wikipedia.homeworks.homework20.HierarchyClass

class KWebViewElement(private val kWebView: KWebView, private val xPath: String) {

    var name = HierarchyClass("no label")

    operator fun invoke(function: KWebViewElement. () -> Unit) {
        function (this)
    }
    infix fun perform(function: KWebViewElement. () -> Unit): KWebViewElement {
        function(this)
        return this
    }

    fun executeAction (interaction: KWebInteraction. () -> Unit) {
        kWebView {
            withElement(Locator.XPATH, xPath, interaction)
        }
    }

    fun setName (name: HierarchyClass) : KWebViewElement {
        this.name = name
        return this
    }

    fun getName () : HierarchyClass {
        return this.name
    }

    fun withParent(elementName: String): HierarchyClass {
        return HierarchyClass(elementName, name)
    }
}
