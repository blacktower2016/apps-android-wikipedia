package org.wikipedia.homeworks.homework19

import android.app.Activity
import com.kaspersky.kaspresso.device.exploit.Exploit
import io.github.kakaocup.kakao.common.actions.BaseActions
import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext
import io.github.kakaocup.kakao.check.CheckableActions
import io.github.kakaocup.kakao.check.CheckableAssertions
import io.github.kakaocup.kakao.common.assertions.BaseAssertions
import io.github.kakaocup.kakao.edit.EditableActions
import io.github.kakaocup.kakao.text.TextViewAssertions
import org.hamcrest.MatcherAssert.assertThat
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework11.article_offline.ArticleOfflineScreen

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

class Steps(private val textContext: TestContext<*>) {

    fun click(element: BaseActions, name: String) {
        textContext.step("Click on element '$name'") {
            element.click()
        }
    }

    fun disableNetwork() {
        textContext.step("Disable network") {
            textContext.device.network.disable()
        }
    }

    fun enableNetwork() {
        textContext.step("Enable network") {
            textContext.device.network.enable()
        }
    }

    fun setOrientationLeft() {
        textContext.step("Set device orientation LEFT") {
            textContext.device.uiDevice.setOrientationLeft()
        }
    }

    fun setOrientationRight() {
        textContext.step("Set device orientation RIGHT") {
            textContext.device.uiDevice.setOrientationRight()
        }
    }

    fun setOrientationNatural() {
        textContext.step("Set device orientation NATURAL") {
            textContext.device.uiDevice.setOrientationNatural()
        }
    }

    fun setOrientationPortrait() {
        textContext.step("Set device orientation PORTRAIT") {
            textContext.device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
        }
    }

    fun setOrientationLandscape() {
        textContext.step("Set device orientation LANDSCAPE") {
            textContext.device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
        }
    }

    fun typeText(element: EditableActions, name: String, text: String) {
        textContext.step("Type '$text' into element '$name'") {
            element.typeText(text)
        }
    }

    fun setChecked(element: CheckableActions, name: String, state: Boolean) {
        textContext.step("Check element '$name'") {
            element.setChecked(state)
        }
    }

    fun hasText(element: TextViewAssertions, name: String, text: String) {
        textContext.step("Verify element '$name' has text '$text'") {
            element.hasText(text)
        }
    }

    fun hasAnyText(element: TextViewAssertions, name: String) {
        textContext.step("Verify element '$name' has any text") {
            element.hasAnyText()
        }
    }

    fun containsText(element: TextViewAssertions, name: String, text: String) {
        textContext.step("Verify element '$name' contains text '$text'") {
            element.containsText(text)
        }
    }

    fun isChecked(element: CheckableAssertions, name: String) {
        textContext.step("Verify element '$name' is checked") {
            element.isChecked()
        }
    }

    fun isNotChecked(element: CheckableAssertions, name: String) {
        textContext.step("Verify element '$name' is NOT checked") {
            element.isNotChecked()
        }
    }

    fun isDisplayed(element: BaseAssertions, name: String) {
        textContext.step("Verify element '$name' is NOT checked") {
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

    fun openFeaturedArticle() {
        textContext.step("Open featured article") {
            ExploreScreen.items.childWith<FeaturedArticleItem> {
                withDescendant {
                    androidx.compose.ui.test.hasText("Featured article")
                }
            }.articleTitle.click()
        }
    }

    fun verifyArticleScreenOffline() {
        textContext.step("Verify article screen offline") {
            with(ArticleOfflineScreen) {
                isDisplayed(retryButton, "button Retry")
                isDisplayed(errorText, "error text")
                isDisplayed(image, "offline image")
            }
        }
    }
}
