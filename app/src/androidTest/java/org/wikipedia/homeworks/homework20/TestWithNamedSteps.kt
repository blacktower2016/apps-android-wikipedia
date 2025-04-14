package org.wikipedia.homeworks.homework20

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.InTheNewsItem
import org.wikipedia.homeworks.homework07.exploreScreen.inTheNews.InTheNewsRecyclerItem
import org.wikipedia.homeworks.homework09.InTheNewsArticleScreen
import org.wikipedia.homeworks.homework09.InTheNewsItemSimilarArticle
import org.wikipedia.homeworks.homework09.article.ArticleWebViewScreen
import org.wikipedia.main.MainActivity

class TestWithNamedSteps : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @get:Rule
    val permissionRule: GrantPermissionRule = GrantPermissionRule.grant(
        android.Manifest.permission.READ_EXTERNAL_STORAGE,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    @Test
    fun testInTheNewsBlock() {
        run {
            steps {
                click(OnboardingScreen.skipButton)
                childAt<InTheNewsRecyclerItem>(
                    childWithText<InTheNewsItem>(
                        ExploreScreen.items,
                        R.string.view_card_news_title
                    ).items,
                    2
                ) {
                    click(image)
                }

                childAt<InTheNewsItemSimilarArticle>(InTheNewsArticleScreen.items, 1) {
                    click()
                }

                step("Verify that element page)web_view is displayed") {
                ArticleWebViewScreen.pageWebView
                }
            }

        }
    }
}
