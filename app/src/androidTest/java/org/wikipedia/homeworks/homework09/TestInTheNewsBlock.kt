package org.wikipedia.homeworks.homework09

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.ExploreScreen
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem
import org.wikipedia.homeworks.homework07.exploreScreen.inTheNews.InTheNewsRecyclerItem
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.article.ArticleWebViewScreen
import org.wikipedia.main.MainActivity

class TestInTheNewsBlock : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    // TODO:
    //  + Скипаем онбординг
    //  + Находим блок In the news (по тексту заголовка)
    //  + Листаем до третьей картинки и кликаем по ней
    //  + Кликаем по второй статье из списка
    //  + Проверяем, что отображается элемент с ID page_web_view (элемент объявить как KView а не KWebView с которым мы ещё не умеем пока работать)
    //  3. Для каждого задействованного экрана описать PageObject со всеми значимыми элементами

    // for stability animation is off in build.gradle:
    //    testOptions {
    //    animationsDisabled = true
    //  }

    @Test
    fun testInTheNewsBlock() {
        run {
            step("Skip Onboarding screen") {
                OnboardingScreen.skipButton.click()
            }

            ExploreScreen.items.childWith<InTheNewsItem> {
                step("Scroll to 'in the news' block") {
                    withDescendant {
                        withText(R.string.view_card_news_title)
                    }
                }
            }.items.childAt<InTheNewsRecyclerItem>(2) {
                step("Click on the 3rd image") {
                    image.click()
                }
            }

            step("Click on the 2nd article in the list") {
                InTheNewsArticleScreen.items.childAt<InTheNewsItemSimilarArticle>(1) {
                    click()
                }
            }

            step("Verify that element page)web_view is displayed") {
                ArticleWebViewScreen.pageWebView.isDisplayed()
            }

        }
    }
}
