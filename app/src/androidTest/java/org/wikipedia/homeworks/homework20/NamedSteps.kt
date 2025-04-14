package org.wikipedia.homeworks.homework20

import android.app.Activity
import androidx.compose.ui.test.hasText
import io.github.kakaocup.kakao.common.actions.BaseActions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.common.utilities.getResourceString
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import org.hamcrest.MatcherAssert.assertThat
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem

// TODO: Домашнее задание №19. Унифицированные шаги.
//
//1. Задание выполняем в homeworks/homework19
//2. Воспроизвести создание класса Steps как на уроке, включая расширение TestContext
//3. Добавить в Steps методы
//- click()
//- disableNetwork()
//- enableNetwork()
//- typeText() для EditableActions
//- setChecked() для CheckableActions плюс передавать состояние которое нужно установить
//- setOrientationLeft()
//- setOrientationRight()
//- setOrientationNatural()
//- hasText()
//- hasAnyText()
//- containsText()
//- isChecked()
//- isNotChecked()
//- isDisplayed()
//- по желанию/необходимости дополнить другими
//4. Скопировать несколько существующих сценариев в один тестовый класс,
// в которых преобразовать все вызовы методов в новые шаги.

class NamedSteps(private val textContext: TestContext<*>) {

    operator fun invoke(function: NamedSteps.() -> Unit) {
        function()
    }

    fun click(element: BaseActions) {
        textContext.step("Click on element '${element.getName()}'") {
            element.click()
        }
    }

    fun <T> childWithText(items: KRecyclerView, text: String) {
        textContext.step("Scroll to '$text' block of '${items.getName()}'") {
            items.getWithDescendantText<KRecyclerItem<T>>(text)
        }
    }

    fun <T> childWithText(items: KRecyclerView, textId: Int): T {
        return items.getWithDescendantText<KRecyclerItem<T>>(textId) as T
    }

    fun <T> childWithText(
        items: KRecyclerView,
        textId: Int,
        function: KRecyclerItem<T>.() -> Unit
    ): Unit {
        textContext.step("Get block of '${items.getName()}' with text '${getResourceString(textId)}'")
        {
            items.invokeWithDescendantText<KRecyclerItem<T>>(textId, function) as T
        }
    }

    fun <T> childWithText(
        items: KRecyclerView,
        text: String,
        function: KRecyclerItem<T>.() -> Unit
    ): Unit {
        textContext.step("Get block of '${items.getName()}' with text '$text'")
        {
            items.invokeWithDescendantText<KRecyclerItem<T>>(text, function) as T
        }
    }


    fun <T : KRecyclerItem<*>> childAt(
        items: KRecyclerView,
        position: Int,
        function: KRecyclerItem<T>.() -> Unit
    ): Unit {
        textContext.step("Find $position block of '${items.getName()}'") {
            items.invokeAtIndex<KRecyclerItem<T>>(
                position = position,
                function = function
            )
        }
    }

    fun <T : KRecyclerItem<*>> childAt(
        items: KRecyclerView,
        position: Int
    ): T {
//        textContext.step("Find $position block of '${items.getName()}'") {
            return items.getWithIndex<KRecyclerItem<T>>(
                position = position,
            ) as T
//        }
    }

    fun isDisplayed(element: BaseAssertions) {
        textContext.step("Verify element '${(element as BaseActions)}' is NOT checked") {
            element.isDisplayed()
        }
    }

    fun verifyLandscapeOrientation() {
        textContext.step("Verify that device is in LANDSCAPE mode") {
            assertThat(
                "Device should be in landscape mode",
                !textContext.device.uiDevice.isNaturalOrientation
            )
        }
    }

    fun verifyPortraitOrientation() {
        textContext.step("Verify that device is in PORTRAIT mode") {
            assertThat(
                "Device should be in portrait mode",
                textContext.device.uiDevice.isNaturalOrientation
            )
        }
    }

    fun rotateDevice() {
        textContext.step("Rotate device") {
            textContext.device.exploit.rotate()
        }
    }

    fun wakeUpDevice() {
        textContext.step("Wake up device") {
            textContext.device.uiDevice.wakeUp()
        }
    }

    fun pressHome() {
        textContext.step("Press Home") {
            textContext.device.exploit.pressHome()
        }
    }

    fun pressRecentApps() {
        textContext.step("Press Recent apps twice") {
            // TODO: check why it is not pressed
//                device.uiDevice.pressRecentApps()


//            textContext.device.apps.openRecent("Wikipedia Android App")
            textContext.device.uiDevice.pressRecentApps()
        }
    }

    fun verifyCurrentActivity(expectedActivityClass: Class<out Activity>) {
        textContext.step("Check that activity '${expectedActivityClass.name}' is active") {
            textContext.device.activities.isCurrent(expectedActivityClass)
        }
    }

    // TODO: make generic, not hardcoded
    fun openFeaturedArticle() {
        textContext.step("Open featured article") {
            ExploreScreen.items.childWith<FeaturedArticleItem> {
                withDescendant {
                    hasText("Featured article")
                }
            }.articleTitle.click()
        }
    }

    fun sleep(msec: Long) {
        textContext.step("Wait for $msec msec") {
            Thread.sleep(msec)
        }
    }
}
