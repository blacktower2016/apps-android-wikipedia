package org.wikipedia.homeworks.homework19

import android.os.Environment
import androidx.compose.ui.test.hasText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.kaspersky.kaspresso.testcases.core.testcontext.BaseTestContext
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

class DeviceTestWithSteps : TestCase(Kaspresso.Builder.withForcedAllureSupport()) {

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
                val steps = Steps(textContext = this)
                steps.verifyLandscapeOrientation()
                steps.rotateDevice()
                steps.verifyPortraitOrientation()
            }
    }

    @Test
    fun testScreenOffAndOn() {
        before("Test screen off and on") {
            device.uiDevice.sleep()
        }.after {
            device.uiDevice.wakeUp()
        }.run {
            val steps = Steps(this)
            steps.isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
            steps.wakeUpDevice()
            steps.isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
        }
    }

    @Test
    fun testAppAfterMinimizing() {
        run {
            val steps = Steps(this)
            steps.isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
            steps.pressHome()
            steps.pressRecentApps()
            steps.pressRecentApps()
            steps.isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
        }
    }

    @Test
    fun testMainActivityIsActive() {
        run {
            val steps = Steps(this)
            steps.click(OnboardingScreen.skipButton, "button 'Skip'")
            steps.verifyCurrentActivity(MainActivity::class.java)
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
            val steps = Steps(this)
            steps.openFeaturedArticle()
            steps.verifyArticleScreenOffline()
            steps.enableNetwork()
            steps.click(ArticleOfflineScreen.retryButton, "button 'Retry'")
            Thread.sleep(2000)
            flakySafely {
                steps.isDisplayed(ArticleWebViewScreen.title, "title")
            }
        }
    }
}
