package org.wikipedia.homeworks.homework22

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher


class HasIdAction(private val id: Int) : ViewAction {

    private var result = false

    fun getResult(): Boolean {
        return result
    }

    override fun getConstraints(): Matcher<View> {
        return ViewMatchers.isAssignableFrom(View::class.java)
    }

    override fun getDescription(): String {
        return "View Has Id"
    }

    override fun perform(uiController: UiController?, view: View?) {
        if (view == null) {
            throw AssertionError("Please provide not null view")
        }
        if (id == view.id) {
            result = true
        } else {
            val found = view.findViewById<View>(id)
            println(found.tooltipText)
            if (found != null) {
                result = true
            }
        }
    }
}
