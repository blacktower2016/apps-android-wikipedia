package org.wikipedia.homeworks.homework11

import android.os.Environment
import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.article.ArticleWebViewScreen
import org.wikipedia.homeworks.homework11.article_offline.ArticleOfflineScreen
import org.wikipedia.main.MainActivity
import java.util.Locale

class DeviceTest : TestCase() {

    // TODO:
    //  2. Написать тесты по уже имеющимся экранам, но с применением методов управления девайсом:
    //   - поворот экрана и проверка ориентации через метод device.uiDevice.isNaturalOrientation
    //   - выключение экрана, включение и проверка отображения элемента (любого)
    //   - "свернуть" приложение кнопкой home и развернуть дважды нажав recent apps
    //     и проверить отображение элемента (любого)
    //   - выключить сеть, перейти в статью и проверить отображение ошибки и кнопки Retry.
    //     Включить сеть и нажать Retry, проверить отображение заголовка
    //     (может работать некорректно, в этом случае забить на тест)
    //   - поменять язык приложения и проверить текст какой-нибудь кнопки (не через ресурсы)
    //   - проверить, что сейчас активна MainActivity.
    //   - не забываем про восстановление состояния девайса через after.
    //  3. Задание повышенной сложности: сделать скриншот экрана, скопировать его с девайса на хост
    //    в директорию build из теста с использованием adbServer объекта.

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun testDeviceOrientation() {
        before("Check orientation switching") {
            device.exploit.setOrientation(Exploit.DeviceOrientation.Landscape)
        }
            .after {
                device.exploit.setOrientation(Exploit.DeviceOrientation.Portrait)
            }
            .run {
                step("Check device orientation") {
                    assertThat(
                        "Device should be in landscape mode",
                        !device.uiDevice.isNaturalOrientation
                    )
                }
                step("Rotate device") {
                    device.exploit.rotate()
                }
                step("Check device orientation") {
                    assertThat(
                        "Device should be in portrait mode",
                        device.uiDevice.isNaturalOrientation
                    )
                }
            }
    }

    @Test
    fun testScreenOffAndOn() {
        before("Test screen off and on") {
            device.uiDevice.sleep()
        }.after {
            device.uiDevice.wakeUp()
        }.run {
            step("Check visibility of skipButton in sleep mode")
            {
                assertThat("Device screen should be off", !device.uiDevice.isScreenOn)
                OnboardingScreen.skipButton.isVisible()
            }
            step("Wake up device") {
                device.uiDevice.wakeUp()
            }
            step("Check visibility of skipButton in waked up mode")
            {
                assertThat("Device screen should be on", device.uiDevice.isScreenOn)
                OnboardingScreen.skipButton.isVisible()
            }
        }
    }

    @Test
    fun testAppAfterMinimizing() {
        run {
            step("Check visibility of skipButton")
            {
                OnboardingScreen.skipButton.isDisplayed()
            }
            step("Press Home") {
                device.exploit.pressHome()
            }
            step("Press Recent apps twice") {
                // TODO: check why it is not pressed
//                device.uiDevice.pressRecentApps()


                device.apps.openRecent("Wikipedia Android App")
                device.uiDevice.pressRecentApps()
            }
            step("Check visibility of skipButton")
            {
                OnboardingScreen.skipButton.isVisible()
            }
        }
    }

    @Test
    fun testMainActivityIsActive() {
        run {
            step("Skip onboarding screen") {
                OnboardingScreen.skipButton.click()
            }
            step("Check that application is active") {
                device.activities.isCurrent(MainActivity::class.java)
            }
        }
    }

    @Test
    fun testArticleWithoutNetwork() {
        before("Open article with network off") {
            OnboardingScreen.skipButton.click()
            device.network.disable()
        }.after {
            device.network.enable()
        }.run {
            step("Open featured article") {
                ExploreScreen.items.childWith<FeaturedArticleItem> {
                    withDescendant {
                        hasText("Featured article")
                    }
                }.articleTitle.click()
            }
            step("Verify article screen offline") {
                with(ArticleOfflineScreen) {
                    retryButton.isVisible()
                    errorText.isVisible()
                    image.isVisible()
                }
            }

            step("Enable network") {
                device.network.enable()
            }
            step("Click retry") {
                ArticleOfflineScreen.retryButton.click()
                Thread.sleep(2000)
            }
            step("Verify that title is displayed") {
                // TODO: not working, ned to find another method to check
                ArticleWebViewScreen.title.isDisplayed()
            }
        }
    }


    @Test
    fun testChangeLanguage() {
        val locale = Locale.ITALIAN
        before {
            device.language.switchInApp(locale)
        }.after {
            device.language.switchInApp(Locale.US)
        }.run {
            step("Check text of skip button in locale $locale") {
                with(OnboardingScreen.skipButton) {
                    containsText("Salta")
                }
                device.screenshots.take("Scrrenshot_")
                println("${it.testClassName}")
                device.files.pull("${Environment.getExternalStorageDirectory().absolutePath}" +
                        "/Documents/screenshots/org.wikipedia.homeworks.homework11.DeviceTest/" +
                        "testChangeLanguage/",
                    "~/StudioProjects/apps-android-wikipedia/app/build")
            }
        }
    }
}
