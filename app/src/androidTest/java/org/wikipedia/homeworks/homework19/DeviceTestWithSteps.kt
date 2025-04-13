package org.wikipedia.homeworks.homework19

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.rule.GrantPermissionRule
import com.kaspersky.components.alluresupport.withForcedAllureSupport
import com.kaspersky.kaspresso.device.exploit.Exploit
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.wikipedia.homeworks.homework08.OnboardingScreen
import org.wikipedia.homeworks.homework09.article.ArticleWebViewScreen
import org.wikipedia.homeworks.homework11.article_offline.ArticleOfflineScreen
import org.wikipedia.main.MainActivity

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
                steps {
                    verifyLandscapeOrientation()
                    rotateDevice()
                    verifyPortraitOrientation()
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
            steps {
                isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
                wakeUpDevice()
                isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
            }
        }
    }

    @Test
    fun testAppAfterMinimizing() {
        run {
            steps {
                isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
                pressHome()
                pressRecentApps()
                pressRecentApps()
                isDisplayed(OnboardingScreen.skipButton, "button 'Skip'")
            }
        }
    }

    @Test
    fun testMainActivityIsActive() {
        run {
            steps {
                click(OnboardingScreen.skipButton, "button 'Skip'")
                verifyCurrentActivity(MainActivity::class.java)
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
            steps {
                openFeaturedArticle()
                with(ArticleOfflineScreen) {
                    isDisplayed(retryButton, "button Retry")
                    isDisplayed(errorText, "error text")
                    isDisplayed(image, "offline image")
                }
                enableNetwork()
                click(ArticleOfflineScreen.retryButton, "button 'Retry'")
                sleep(2000)
                flakySafely {
                    isDisplayed(ArticleWebViewScreen.title, "title")
                }
            }
        }
    }
}
