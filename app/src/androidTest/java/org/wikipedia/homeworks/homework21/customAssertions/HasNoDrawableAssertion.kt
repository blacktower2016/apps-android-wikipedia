package org.wikipedia.homeworks.homework21.customAssertions

import android.view.View
import android.widget.ImageView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.junit.Assert

class HasNoDrawableAssertion : ViewAssertion {
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (view is ImageView) {
            Assert.assertTrue("Should not have drawable", view.drawable == null)
        } else {
            throw noViewFoundException ?: AssertionError("View is not ImageView")
        }
    }
}
