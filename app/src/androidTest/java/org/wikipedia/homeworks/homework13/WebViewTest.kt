package org.wikipedia.homeworks.homework13

import android.os.Environment
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.web.webdriver.Locator
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.FeaturedArticleItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.article.ArticleWebViewScreen
import org.wikipedia.main.MainActivity

class WebViewTest : TestCase() {
    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    fun openWebViewArticle() {
        run {
            step("Skip Onboarding screen") {
                OnboardingScreen.skipButton.click()
            }

            step("Scroll to 'Featured article' block") {
                ExploreScreen.items.childWith<FeaturedArticleItem> {
                    withDescendant {
                        withText(R.string.view_featured_article_card_title)
                    }
                }.articleTitle.click()
                Thread.sleep(1000)
            }
        }
    }

// TODO:
//    Домашнее задание №13. WebView
//    1. Задание выполняем в homeworks/homework13
//    2. Написать сценарий:
//    - Переход в произвольную статью
//    - Проскроллить до элемента с id "References"
//    - Проверяем текст в элементе с id "References" (это уникальный элемент с постоянным текстом в английской локали)
//    - Написать xpath до пятой ссылки в тексте как на первой картинке
//    - Нажать на этот элемент
//    - Описать экран для всплывающего окна
//    - Во всплывающем окне (вторая картинка) проверить на соответствие текст заголовка и номер в строке (5.)
//    - Кнопкой back закрыть всплывающее окно
//    - Найти вторую ссылку с CSS классом mw-redirect и нажать на неё
//    - Описать всплывающий экран и нажать на нём кнопку Read article
//    - Перейти по этой кнопке в новую статью
//    - Проскроллить до элемента с id "References"

    fun refLocator(num: Int): String {
//        return "//*[@class='reference-link'][contains(@style, 'mw-Ref %s;')]".format(num)
//        return "//sup[@id='cite_ref-%s']/a".format(num)
        return "#cite_ref-%s > a".format(num)
    }


    @Test
    fun webViewTest() {
        before {
            openWebViewArticle()
        }.after {
        }.run {
            ArticleWebViewScreen.pageWebView {
                withElement(Locator.CSS_SELECTOR, "#References") {
                    scroll()
                    hasText("References")
                }
            }
        }
    }

    @Test
    fun refLinkFiveTest() {
        before {
            openWebViewArticle()
        }.after {
            pullScreenshots()
        }.run {
            step("Open reference link 5") {
                ArticleWebViewScreen.pageWebView {
//                    withElement(Locator.CSS_SELECTOR, "#cite_ref-5 > a") {
                    withElement(Locator.CSS_SELECTOR, "#cite_ref-5  a") {
                        scroll()
                        makeScreenshot()
//                        hasText("[5]")
                        click()
                    }
                    makeScreenshot()
                }
            }
            step("Verify reference popup title") {
                WebViewReferenceScreen.referenceId {
                    containsText("5.")
                }
            }
            step("Verify reference number") {
                WebViewReferenceScreen.referenceTitleText {
                    containsText("Reference")
                }
            }
            step("Press back") {
                var visible = true
                while (visible) {
                    try {
                        WebViewReferenceScreen.referenceTitleText.isNotDisplayed()
                        visible = false
                    } catch (ex: AssertionError) {
                        device.uiDevice.pressBack()
                        continue
                    } catch (ex: NoMatchingViewException) {
                        visible = false
                    }


                }
            }

            step("Click on 2nd link with css class mw-redirect") {
                ArticleWebViewScreen.pageWebView {
                    withElement(
                        Locator.XPATH,
                        "//body/div/section[1]/p[1]/a[contains(@class, mw-redirect)][2]"
                    ) {
                        scroll()
                        click()
                    }
                }
            }

            step("Click read article") {
                ArticleLinkPopupScreen.readArticleButton.click()
            }

            step("Scroll to references") {
                ArticleWebViewScreen.pageWebView {
                    withElement(Locator.CSS_SELECTOR, "#References") {
                        scroll()
                    }
                }
            }


        }
    }

    private fun makeScreenshot() {
        device.screenshots.take("Scrrenshot_")
    }

    private fun pullScreenshots() {
        val currentCanonicalName = this.javaClass.canonicalName
        device.files.pull(
            Environment.getExternalStorageDirectory().absolutePath +
                    "/Documents/screenshots/$currentCanonicalName",
            "app/build/screenshots"
        )
    }
}
