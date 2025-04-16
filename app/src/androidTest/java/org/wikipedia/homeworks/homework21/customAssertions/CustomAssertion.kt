package org.wikipedia.homeworks.homework21.customAssertions

import android.view.View
import android.widget.TextView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class CustomAssertion(val text: String) : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is TextView) {
            Assert.assertEquals("Text should be equal '$text'", text, view.text)
        } else {
            throw noViewFoundException ?: AssertionError("View ia not TextView")
        }
    }
}
