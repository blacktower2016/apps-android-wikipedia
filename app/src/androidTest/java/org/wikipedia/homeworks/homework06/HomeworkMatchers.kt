package org.wikipedia.homeworks.homework06

import org.hamcrest.Description
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.anglesAmountEquals
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.colorIs
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.sideAmountIsEven
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.sideIsWithinRange
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.sideSizeIsPositive
import org.wikipedia.homeworks.homework06.ShapeMatcher.Companion.sidesAmountIsPositive

enum class Color { RED, BLUE, GREEN, YELLOW, BLACK, WHITE }

data class Shape(val side: Float, val sidesAmount: Int, val color: Color)

val shapes = listOf(
    Shape(10f, 3, Color.RED),
    Shape(5f, 4, Color.BLUE),
    Shape(7f, 2, Color.GREEN),
    Shape(0.5f, 1, Color.YELLOW),
    Shape(-3f, 5, Color.BLACK),
    Shape(8f, -2, Color.WHITE),
    Shape(12f, 6, Color.RED),
    Shape(15f, 8, Color.BLUE),
    Shape(20f, 4, Color.GREEN),
    Shape(9f, 5, Color.YELLOW),
    Shape(2f, 3, Color.BLACK),
    Shape(11f, 7, Color.WHITE),
    Shape(6f, 10, Color.RED),
    Shape(3f, 2, Color.BLUE),
    Shape(4f, 1, Color.GREEN),
    Shape(25f, 12, Color.YELLOW),
    Shape(30f, 14, Color.BLACK),
    Shape(35f, 16, Color.WHITE),
    Shape(40f, 18, Color.RED),
    Shape(50f, 20, Color.BLUE),
)

class SideRangeMatcher(private val minValue: Float, private val maxValue: Float) :
    TypeSafeMatcher<Shape>() {
    init {
        require(minValue <= maxValue) { "min value should be less or equal max value" }
    }

    override fun describeTo(description: Description?) {
        description?.appendText("Side is in range")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && item.side in minValue..maxValue
    }
}

class AngleAmountMatcher(private val angleAmount: Int) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Angle amount is $angleAmount")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && if (item.sidesAmount > 2) {
            item.sidesAmount == angleAmount
        } else angleAmount == 0
    }
}

class SideAmountEvenMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Side amount is even")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && item.sidesAmount % 2 == 0
    }
}

class ColorMatcher(private val color: Color) : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Color is $color")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && item.color == color
    }
}

class SidesAmountPositiveMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Sides amount is positive")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && item.sidesAmount > 0
    }
}

class SideSizePositiveMatcher : TypeSafeMatcher<Shape>() {
    override fun describeTo(description: Description?) {
        description?.appendText("Side size is positive")
    }

    override fun matchesSafely(item: Shape?): Boolean {
        return item is Shape && item.side > 0
    }
}

class ShapeMatcher {
    companion object {
        fun sideIsWithinRange(minValue: Float, maxValue: Float): SideRangeMatcher {
            return SideRangeMatcher(minValue, maxValue)
        }

        fun anglesAmountEquals(anglesAmount: Int): AngleAmountMatcher {
            return AngleAmountMatcher(anglesAmount)
        }

        fun sideAmountIsEven(): SideAmountEvenMatcher {
            return SideAmountEvenMatcher()
        }

        fun colorIs(color: Color): ColorMatcher {
            return ColorMatcher(color)
        }

        fun sidesAmountIsPositive(): SidesAmountPositiveMatcher {
            return SidesAmountPositiveMatcher()
        }

        fun sideSizeIsPositive(): SideSizePositiveMatcher {
            return SideSizePositiveMatcher()
        }
    }
}


infix fun List<Shape?>.filterByMatcher(matcher: TypeSafeMatcher<Shape>): List<Shape?> {
    return this.filter { matcher.matches(it) }
}

fun main() {
    assertThat("Shape side should be within range", shapes[1], sideIsWithinRange(.01f, 10f))
    assertThat("Shape side should be within range", shapes[1], anglesAmountEquals(4))
    assertThat("Shape side amount is even", shapes[1], sidesAmountIsPositive())
    assertThat("Shape color is correct", shapes[1], colorIs(Color.BLUE))
    assertThat("Side amount is positive", shapes[1], sidesAmountIsPositive())
    assertThat("Side amount is positive", shapes[1], sideSizeIsPositive())

    println(shapes.filterByMatcher(sideIsWithinRange(.01f, 1f)))
    println(shapes.filterByMatcher(sideIsWithinRange(10f, 40f)))
    println(shapes.filterByMatcher(sideAmountIsEven()))
    println(shapes.filterByMatcher(colorIs(Color.RED)))
    println(shapes.filterByMatcher(colorIs(Color.YELLOW)))
    println(shapes.filterByMatcher(sidesAmountIsPositive()))
    println(shapes.filterByMatcher(sideSizeIsPositive()))
    println(shapes.filterByMatcher(anglesAmountEquals(0)))
    assertThat(
        "Shape matches all conditions",
        shapes[1],
        allOf(sidesAmountIsPositive(), sideIsWithinRange(.01f, 10f), colorIs(Color.RED))
    )
}
