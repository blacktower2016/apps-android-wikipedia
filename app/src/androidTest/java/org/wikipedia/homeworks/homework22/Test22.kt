package org.wikipedia.homeworks.homework22

import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.R
import org.wikipedia.homeworks.homework07.exploreScreen.SearchCardViewItem
import org.wikipedia.homeworks.homework20.ExploreScreen
import org.wikipedia.homeworks.homework20.OnboardingScreen
import org.wikipedia.homeworks.homework20.getName
import org.wikipedia.homeworks.homework21.extensions.getText
import org.wikipedia.main.MainActivity
import java.lang.Thread.sleep

class Test22 : TestCase() {

    @get:Rule
    val activityScenarioRule: ActivityScenarioRule<MainActivity> =
        ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test() {
        run {
            step("Skip onboarding") {
                OnboardingScreen.skipButton.click()
            }


//            println(
                ExploreScreen.featuredArticleItem(
                    index = 0,
                    targetId = R.id.view_featured_article_card_header,
                    limiter = 10,
                    blockNmae = "featured_aricel"
                )
                    .click()
//            )

            ExploreScreen.searchCardViewItem(
                index = 0,
                targetId = R.id.search_container,
                limiter = 3,
                blockNmae = "featured_aricel"
            ).voiceIcon
                .click()

            sleep(5000)
        }
    }

}
